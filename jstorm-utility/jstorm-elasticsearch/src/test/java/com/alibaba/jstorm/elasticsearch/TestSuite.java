/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.jstorm.elasticsearch;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.topology.TopologyBuilder;

import com.alibaba.jstorm.elasticsearch.bolt.EsIndexBolt;
import com.alibaba.jstorm.elasticsearch.bolt.EsQueryBolt;
import com.alibaba.jstorm.elasticsearch.common.EsConfig;
import com.alibaba.jstorm.elasticsearch.common.EsOutputDeclarer;
import com.alibaba.jstorm.elasticsearch.index.TestIndexSpout;
import com.alibaba.jstorm.elasticsearch.mapper.EsDefaultIndexMapper;
import com.alibaba.jstorm.elasticsearch.query.TestQueryBolt;
import com.alibaba.jstorm.elasticsearch.query.TestQueryMapper;
import com.alibaba.jstorm.elasticsearch.query.TestQuerySpout;
import com.alibaba.jstorm.elasticsearch.userdefine.TestIndexBolt;

public class TestSuite {

  private static LocalCluster cluster;
  private static Config conf;
  private String now = "Test";
  private static EsConfig esConfig;

  @BeforeClass
  public static void init() {
    cluster = new LocalCluster();
    conf = new Config();
    conf.put(Config.TOPOLOGY_MAX_TASK_PARALLELISM, 1);
    esConfig = new EsConfig("test", "127.0.0.1:9300");
  }

  @After
  public void each() {
    try {
      Thread.sleep(60000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    cluster.killTopology(now);
  }

  @AfterClass
  public static void teardown() {
    cluster.shutdown();
  }

  @Test
  public void testIndex() {
    TopologyBuilder builder = new TopologyBuilder();
    builder.setSpout("index-spout", new TestIndexSpout());
    EsIndexBolt esIndexBolt = new EsIndexBolt(esConfig,
        new EsDefaultIndexMapper());
    builder.setBolt("index-bolt", esIndexBolt).shuffleGrouping("index-spout");
    cluster.submitTopology("Index-Test", conf, builder.createTopology());
  }

  @Test
  public void testQuery() {
    TopologyBuilder builder = new TopologyBuilder();
    builder.setSpout("query-spout", new TestQuerySpout());
    EsOutputDeclarer esOutputDeclarer = new EsOutputDeclarer().addField("date");
    EsQueryBolt esIndexBolt = new EsQueryBolt(esConfig, new TestQueryMapper(),
        esOutputDeclarer);
    builder.setBolt("query-bolt", esIndexBolt).shuffleGrouping("query-spout");
    builder.setBolt("end-bolt", new TestQueryBolt()).shuffleGrouping(
        "query-bolt");
    cluster.submitTopology("Query-Test", conf, builder.createTopology());
  }

  @Test
  public void testUserDefine() {
    TopologyBuilder builder = new TopologyBuilder();
    builder.setSpout("user-define-spout", new TestIndexSpout());
    TestIndexBolt esIndexBolt = new TestIndexBolt(esConfig);
    builder.setBolt("user-define-bolt", esIndexBolt).shuffleGrouping(
        "user-define-spout");
    cluster.submitTopology("UserDefine-Test", conf, builder.createTopology());
  }

}

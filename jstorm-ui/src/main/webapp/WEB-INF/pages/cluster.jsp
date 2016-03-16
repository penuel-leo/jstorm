<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="ct" uri="http://jstorm.alibaba.com/jsp/tags" %>
<%--
  Licensed to the Apache Software Foundation (ASF) under one or more
  contributor license agreements.  See the NOTICE file distributed with
  this work for additional information regarding copyright ownership.
  The ASF licenses this file to You under the Apache License, Version 2.0
  (the "License"); you may not use this file except in compliance with
  the License.  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
  --%>

<html>
<head>
    <jsp:include page="layout/_head.jsp"/>
</head>
<body>
<jsp:include page="layout/_header.jsp"/>

<div class="container-fluid">
    <!-- ========================================================== -->
    <!------------------------- cluster summary --------------------->
    <!-- ========================================================== -->
    <h2>Cluster Summary</h2>
    <table class="table table-bordered table-hover table-striped center">
        <thead>
        <tr>
            <th>Cluster Name</th>
            <th>Supervisors</th>
            <th>Ports Usage</th>
            <th>Topologies</th>
            <th>Version</th>
            <th>Conf</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${cluster.clusterName}</td>
            <td>${cluster.supervisors}</td>
            <td>${cluster.slotsUsed} / ${cluster.slotsTotal}</td>
            <td>${cluster.topologies}</td>
            <td>${cluster.stormVersion}</td>
            <td><a href="conf?name=${cluster.clusterName}" target="_blank">conf</a></td>
        </tr>
        </tbody>
    </table>

    <c:if test="${clusterData != null}">
        <!-- ========================================================== -->
        <!------------------------- cluster stats --------------------->
        <!-- ========================================================== -->
        <h2>Cluster Stats</h2>
        <table class="table table-bordered table-striped center text-wrap">
            <thead class="center">
            <tr>
                <c:forEach var="head" items="${clusterHead}">
                    <th><ct:pretty input="${head}" type="head"/></th>
                </c:forEach>
            </tr>
            </thead>
            <tbody>
            <c:choose>
                <c:when test="${clusterData != null}">
                    <tr>
                        <c:forEach var="head" items="${clusterHead}">
                            <c:choose>
                                <c:when test="${head eq 'MemoryUsed'}">
                                    <td data-order="${clusterData.metrics.get(head)}">
                                        <ct:pretty input="${clusterData.metrics.get(head)}"
                                                   type="filesize"/>
                                    </td>
                                </c:when>
                                <c:otherwise>
                                    <td>${clusterData.metrics.get(head)}</td>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </tr>
                    <tr id="chart-tr" class="hidden">
                        <c:forEach var="head" items="${clusterHead}">
                            <td class="topo-chart">
                                <div class="chart-canvas" id="chart-${head}"></div>
                            </td>
                        </c:forEach>
                    </tr>
                </c:when>
                <c:otherwise>
                    <tr class="center">
                        <td colspan="12">
                            No records found.
                        </td>
                    </tr>
                </c:otherwise>
            </c:choose>
            </tbody>
        </table>
    </c:if>

    <!-- ========================================================== -->
    <!------------------------- nimbus summary --------------------->
    <!-- ========================================================== -->
    <h2>Nimbus Summary</h2>
    <table class="table table-bordered table-hover table-striped center">
        <thead>
        <tr>
            <th>Role</th>
            <th>Host</th>
            <th>Uptime</th>
            <th>Version</th>
            <th>Logs</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="nb" items="${nimbus}" varStatus="index">
            <tr>
                <td>${nb.status}</td>
                <td>${nb.ip}:${nb.port}</td>
                <td>${nb.nimbusUpTime}</td>
                <td>${nb.version}</td>
                <td>
                    <a href="files?cluster=${clusterName}&host=${nimbus.get(0).ip}&port=${nimbusPort}"
                       target="_blank">log files</a>
                    <c:if test="${index.first}">
                    | <a href="log?cluster=${clusterName}&host=${nimbus.get(0).ip}&port=${nimbusPort}&file=nimbus.log"
                       target="_blank">nimbus log</a></td>
                    </c:if>
            </tr>
        </c:forEach>
        </tbody>
    </table>


    <!-- ========================================================== -->
    <!------------------------- topology summary --------------------->
    <!-- ========================================================== -->
    <h2>
        Topology Summary
        <button id="jar-btn" type="button" class="btn btn-warning" style="float:right;" data-title="ADD TOPOLOGY" data-container="body" data-placement="left"
                data-toggle="popover">New Topology
        </button>
    </h2>
    <table class="table table-bordered table-hover table-striped sortable center"
           data-table="${topologies.size() > PAGE_MAX ? "full" : "sort"}">
        <thead>
        <tr>
            <th>Topology Name</th>
            <th>Topology Id</th>
            <th>Status</th>
            <th>Uptime</th>
            <th>Num workers</th>
            <th>Num tasks</th>
            <th>Conf</th>
            <th>Error</th>
            <th>Operation</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="topo" items="${topologies}">
            <tr>
                <td><a href="topology?id=${topo.id}&cluster=${clusterName}">${topo.name}</a></td>
                <td>${topo.id}</td>
                <td><ct:status status="${topo.status}"/></td>
                <td>${topo.uptime}</td>
                <td>${topo.workersTotal}</td>
                <td>${topo.tasksTotal}</td>
                <td>
                    <a href="conf?name=${clusterName}&type=topology&topology=${topo.id}" target="_blank">
                        conf
                    </a>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${topo.errorInfo != null}">
                            <a href="topology?id=${topo.id}&cluster=${clusterName}#comp-tab"
                               title='See topology page for detail'
                               class="error-msg">${topo.errorInfo}</a>
                        </c:when>
                        <c:otherwise>
                            <!-- nothing -->
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <button id="restart-btn-${topo.name}" type="button" class="btn btn-warning" data-title="${topo.name}" data-container="body"
                            data-placement="left" data-toggle="popover" data-type="restartBtn">
                        Restart
                    </button>
                    <button id="more-btn-${topo.name}" type="button" class="btn btn-warning" data-title="${topo.name}" data-container="body" data-placement="left"
                            data-toggle="popover" data-type="moreBtn">
                        More
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <!-- ========================================================== -->
    <!------------------------- supervisor summary --------------------->
    <!-- ========================================================== -->
    <h2>Supervisor Summary
        <small>(Total: ${supervisors.size()})</small>
    </h2>
    <table class="table table-bordered table-hover table-striped sortable center"
           data-table="${supervisors.size() > PAGE_MAX ? "full" : "sort"}">
        <thead>
        <tr>
            <th>IP</th>
            <th>Host</th>
            <th>Uptime</th>
            <th>Ports Usage</th>
            <th>Conf</th>
            <th>Logs</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="sv" items="${supervisors}">
            <tr>
                <td><a href="supervisor?cluster=${clusterName}&host=${sv.ip}">
                        ${sv.ip}</a></td>
                <td>${sv.host}</td>
                <td>${sv.uptime}</td>
                <td>${sv.slotsUsed} / ${sv.slotsTotal}</td>
                <td>
                    <a href="conf?name=${clusterName}&type=supervisor&host=${sv.ip}" target="_blank">
                        conf
                    </a>
                </td>
                <td>
                    <a href="files?cluster=${clusterName}&host=${sv.ip}&port=${supervisorPort}"
                       target="_blank">log files</a> |
                    <a href="log?cluster=${clusterName}&host=${sv.ip}&port=${supervisorPort}&file=supervisor.log"
                       target="_blank">supervisor log</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <!-- ========================================================== -->
    <!------------------------- zookeeper summary --------------------->
    <!-- ========================================================== -->
    <h2><a href="zookeeper?name=${clusterName}">Zookeeper Summary</a></h2>
    <table class="table table-bordered table-hover table-striped center">
        <thead>
        <tr>
            <th>IP</th>
            <th>Host</th>
            <th>Port</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="zk" items="${zkServers}" varStatus="index">
            <tr>
                <td>${zk.ip}</td>
                <td>${zk.host}</td>
                <c:if test="${index.first}">
                    <td rowspan="${zkServers.size()}" style="vertical-align: middle;">
                            ${zk.port}
                    </td>
                </c:if>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<input type="hidden" value="" id="currentCheckedTopologyName" />

<jsp:include page="layout/_footer.jsp"/>
<script src="assets/js/echarts/echarts.js"></script>
<script src="assets/js/storm.js"></script>
<script>
    $(function () {
        $('[data-toggle="tooltip"]').tooltip();

        //draw metrics charts
        $.getJSON("api/v2/cluster/${clusterName}/metrics", function (data) {
            var echarts = new EChart();
            data = data['metrics'];
            var width = ($('.container-fluid').width() / data.length) - 2;
            data.forEach(function (e) {
                var selector = document.getElementById('chart-' + e.name);
                selector.setAttribute("style", "width:"+ width + "; height: 100px");
                echarts.init(selector, e);
            });

            $("#chart-tr").toggleClass("hidden");
        });
    });

    $(function () {
        $('#jar-btn').popover({
            html: true,
            content: function () {
                var content =
                        '<div class="modal-body hide" style="height: 150px;" id="jar-modal-div">' +
                        '<div class="form-group">' +
                        '<label for="jarFile">Upload New Topology Jar File</label>' +
                        '<input type="file" id="jarFile" class="form-control"/>' +
                        '</div>' +
                        '<div class="form-group">' +
                        '<label for="classPath">New topology main class path</label>' +
                        '<input type="text" id="classPath" class="form-control" placeholder="com.ndpmedia.test.topology.TestTopology"/>' +
                        '</div>' +
                        '<a class="btn btn-info col-xs-offset-3" style="float:right;margin-bottom: 10px" href="javascript:;" onclick="operate(20)">New and Start</a>' +
                        '</div>';
                return $(content).html();
            }
        });
        $('[data-type="restartBtn"]').each(function () {
            $(this).popover({
                html: true,
                content: function () {
                    var content =
                            '<div class="modal-body hide" style="height: 150px;" id="restart-modal-div">' +
                            '<div class="form-group">' +
                            '<label for="restartFile">if config file is null then restart without argument<br>otherwise restart with uploaded config file</label>' +
                            '<input type="file" id="restartFile" class="form-control"/>' +
                            '</div>' +
                            '<a class="btn btn-info col-xs-offset-3" style="float:right;margin-bottom: 10px" href="javascript:;" onclick="operate(10)">Restart</a>' +
                            '</div>';
                    return $(content).html();
                }
            });
        });

        $('[data-type="moreBtn"]').each(function () {
            $(this).popover({
                html: true,
                content: function () {
                    var content =
                            '<div class="modal-body hide" style="height: 230px;" id="more-modal-div">' +
                            '<div class="form-group"><a class="btn btn-info" class="form-control" href="javascript:;" onclick="operate(0)">Activate</a></div>' +
                            '<div class="form-group"><a class="btn btn-info" class="form-control" href="javascript:;" onclick="operate(1)">Deactivate</a></div>' +
                            '<div class="form-group"><a class="btn btn-info" class="form-control" href="javascript:;" onclick="operate(2)">Kill</a></div>' +
                            '<div class="form-group"><a class="btn btn-info" class="form-control" href="javascript:;" onclick="operate(3)">Rebalance</a></div>' +
                            '</div>'
                    return $(content).html();
                }
            });
        });

        $("[data-toggle='popover']").on("shown.bs.popover", function () {
            $('#currentCheckedTopologyName').val(this.getAttribute('data-title'));
        })
    });

    $('body').on('click', function (e) {
        $('[data-toggle="popover"]').each(function () {
            if (!$(this).is(e.target) && $(this).has(e.target).length === 0 && $('.popover').has(e.target).length === 0) {
                $(this).popover('hide');
            }
        });
    });

    function operate(action) {
        var formData = new FormData();
        var topologyName = $('#currentCheckedTopologyName').val();
        formData.append('topologyName', topologyName)
        formData.append('action', action)
        if (action == 10) {
            if($('#restartFile')[0].files.length == 1) {
                formData.append('file', $('#restartFile')[0].files[0]);
            }
            postForm('/operate/restart', formData);
        } else if (action == 20) {//jarFile
            formData.append('file', $('#jarFile')[0].files[0]);
            formData.append('classPath', $('#classPath').val());
            postForm('/operate/jar', formData);
        } else {
            postForm('/operate/more', formData);
        }

    }

    function postForm(url, formData) {
        $('[data-toggle="popover"]').each(function () {
            $(this).popover('hide');
        });
        alert("task has been submitted, please wait...");
        $.ajax(url, {
            enctype: 'multipart/form-data',
            data: formData,
            processData: false,
            contentType: false,
            type: 'POST',
        }).done(function (data) {
            var w = window.open();
            $(w.document.body).html(data.msg.replace(/\\n/g,"<br>"));
            window.location.reload();
        });
    }
</script>
</body>
</html>
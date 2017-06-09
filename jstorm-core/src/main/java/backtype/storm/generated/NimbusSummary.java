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
/**
 * Autogenerated by Thrift Compiler (0.9.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package backtype.storm.generated;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.2)", date = "2017-2-22")
public class NimbusSummary implements org.apache.thrift.TBase<NimbusSummary, NimbusSummary._Fields>, java.io.Serializable, Cloneable, Comparable<NimbusSummary> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("NimbusSummary");

  private static final org.apache.thrift.protocol.TField NIMBUS_MASTER_FIELD_DESC = new org.apache.thrift.protocol.TField("nimbusMaster", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField NIMBUS_SLAVES_FIELD_DESC = new org.apache.thrift.protocol.TField("nimbusSlaves", org.apache.thrift.protocol.TType.LIST, (short)2);
  private static final org.apache.thrift.protocol.TField SUPERVISOR_NUM_FIELD_DESC = new org.apache.thrift.protocol.TField("supervisorNum", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField TOTAL_PORT_NUM_FIELD_DESC = new org.apache.thrift.protocol.TField("totalPortNum", org.apache.thrift.protocol.TType.I32, (short)4);
  private static final org.apache.thrift.protocol.TField USED_PORT_NUM_FIELD_DESC = new org.apache.thrift.protocol.TField("usedPortNum", org.apache.thrift.protocol.TType.I32, (short)5);
  private static final org.apache.thrift.protocol.TField FREE_PORT_NUM_FIELD_DESC = new org.apache.thrift.protocol.TField("freePortNum", org.apache.thrift.protocol.TType.I32, (short)6);
  private static final org.apache.thrift.protocol.TField VERSION_FIELD_DESC = new org.apache.thrift.protocol.TField("version", org.apache.thrift.protocol.TType.STRING, (short)7);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new NimbusSummaryStandardSchemeFactory());
    schemes.put(TupleScheme.class, new NimbusSummaryTupleSchemeFactory());
  }

  private NimbusStat nimbusMaster; // required
  private List<NimbusStat> nimbusSlaves; // required
  private int supervisorNum; // required
  private int totalPortNum; // required
  private int usedPortNum; // required
  private int freePortNum; // required
  private String version; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    NIMBUS_MASTER((short)1, "nimbusMaster"),
    NIMBUS_SLAVES((short)2, "nimbusSlaves"),
    SUPERVISOR_NUM((short)3, "supervisorNum"),
    TOTAL_PORT_NUM((short)4, "totalPortNum"),
    USED_PORT_NUM((short)5, "usedPortNum"),
    FREE_PORT_NUM((short)6, "freePortNum"),
    VERSION((short)7, "version");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // NIMBUS_MASTER
          return NIMBUS_MASTER;
        case 2: // NIMBUS_SLAVES
          return NIMBUS_SLAVES;
        case 3: // SUPERVISOR_NUM
          return SUPERVISOR_NUM;
        case 4: // TOTAL_PORT_NUM
          return TOTAL_PORT_NUM;
        case 5: // USED_PORT_NUM
          return USED_PORT_NUM;
        case 6: // FREE_PORT_NUM
          return FREE_PORT_NUM;
        case 7: // VERSION
          return VERSION;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __SUPERVISORNUM_ISSET_ID = 0;
  private static final int __TOTALPORTNUM_ISSET_ID = 1;
  private static final int __USEDPORTNUM_ISSET_ID = 2;
  private static final int __FREEPORTNUM_ISSET_ID = 3;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.NIMBUS_MASTER, new org.apache.thrift.meta_data.FieldMetaData("nimbusMaster", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, NimbusStat.class)));
    tmpMap.put(_Fields.NIMBUS_SLAVES, new org.apache.thrift.meta_data.FieldMetaData("nimbusSlaves", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, NimbusStat.class))));
    tmpMap.put(_Fields.SUPERVISOR_NUM, new org.apache.thrift.meta_data.FieldMetaData("supervisorNum", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.TOTAL_PORT_NUM, new org.apache.thrift.meta_data.FieldMetaData("totalPortNum", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.USED_PORT_NUM, new org.apache.thrift.meta_data.FieldMetaData("usedPortNum", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.FREE_PORT_NUM, new org.apache.thrift.meta_data.FieldMetaData("freePortNum", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.VERSION, new org.apache.thrift.meta_data.FieldMetaData("version", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(NimbusSummary.class, metaDataMap);
  }

  public NimbusSummary() {
  }

  public NimbusSummary(
    NimbusStat nimbusMaster,
    List<NimbusStat> nimbusSlaves,
    int supervisorNum,
    int totalPortNum,
    int usedPortNum,
    int freePortNum,
    String version)
  {
    this();
    this.nimbusMaster = nimbusMaster;
    this.nimbusSlaves = nimbusSlaves;
    this.supervisorNum = supervisorNum;
    set_supervisorNum_isSet(true);
    this.totalPortNum = totalPortNum;
    set_totalPortNum_isSet(true);
    this.usedPortNum = usedPortNum;
    set_usedPortNum_isSet(true);
    this.freePortNum = freePortNum;
    set_freePortNum_isSet(true);
    this.version = version;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public NimbusSummary(NimbusSummary other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.is_set_nimbusMaster()) {
      this.nimbusMaster = new NimbusStat(other.nimbusMaster);
    }
    if (other.is_set_nimbusSlaves()) {
      List<NimbusStat> __this__nimbusSlaves = new ArrayList<NimbusStat>(other.nimbusSlaves.size());
      for (NimbusStat other_element : other.nimbusSlaves) {
        __this__nimbusSlaves.add(new NimbusStat(other_element));
      }
      this.nimbusSlaves = __this__nimbusSlaves;
    }
    this.supervisorNum = other.supervisorNum;
    this.totalPortNum = other.totalPortNum;
    this.usedPortNum = other.usedPortNum;
    this.freePortNum = other.freePortNum;
    if (other.is_set_version()) {
      this.version = other.version;
    }
  }

  public NimbusSummary deepCopy() {
    return new NimbusSummary(this);
  }

  @Override
  public void clear() {
    this.nimbusMaster = null;
    this.nimbusSlaves = null;
    set_supervisorNum_isSet(false);
    this.supervisorNum = 0;
    set_totalPortNum_isSet(false);
    this.totalPortNum = 0;
    set_usedPortNum_isSet(false);
    this.usedPortNum = 0;
    set_freePortNum_isSet(false);
    this.freePortNum = 0;
    this.version = null;
  }

  public NimbusStat get_nimbusMaster() {
    return this.nimbusMaster;
  }

  public void set_nimbusMaster(NimbusStat nimbusMaster) {
    this.nimbusMaster = nimbusMaster;
  }

  public void unset_nimbusMaster() {
    this.nimbusMaster = null;
  }

  /** Returns true if field nimbusMaster is set (has been assigned a value) and false otherwise */
  public boolean is_set_nimbusMaster() {
    return this.nimbusMaster != null;
  }

  public void set_nimbusMaster_isSet(boolean value) {
    if (!value) {
      this.nimbusMaster = null;
    }
  }

  public int get_nimbusSlaves_size() {
    return (this.nimbusSlaves == null) ? 0 : this.nimbusSlaves.size();
  }

  public java.util.Iterator<NimbusStat> get_nimbusSlaves_iterator() {
    return (this.nimbusSlaves == null) ? null : this.nimbusSlaves.iterator();
  }

  public void add_to_nimbusSlaves(NimbusStat elem) {
    if (this.nimbusSlaves == null) {
      this.nimbusSlaves = new ArrayList<NimbusStat>();
    }
    this.nimbusSlaves.add(elem);
  }

  public List<NimbusStat> get_nimbusSlaves() {
    return this.nimbusSlaves;
  }

  public void set_nimbusSlaves(List<NimbusStat> nimbusSlaves) {
    this.nimbusSlaves = nimbusSlaves;
  }

  public void unset_nimbusSlaves() {
    this.nimbusSlaves = null;
  }

  /** Returns true if field nimbusSlaves is set (has been assigned a value) and false otherwise */
  public boolean is_set_nimbusSlaves() {
    return this.nimbusSlaves != null;
  }

  public void set_nimbusSlaves_isSet(boolean value) {
    if (!value) {
      this.nimbusSlaves = null;
    }
  }

  public int get_supervisorNum() {
    return this.supervisorNum;
  }

  public void set_supervisorNum(int supervisorNum) {
    this.supervisorNum = supervisorNum;
    set_supervisorNum_isSet(true);
  }

  public void unset_supervisorNum() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __SUPERVISORNUM_ISSET_ID);
  }

  /** Returns true if field supervisorNum is set (has been assigned a value) and false otherwise */
  public boolean is_set_supervisorNum() {
    return EncodingUtils.testBit(__isset_bitfield, __SUPERVISORNUM_ISSET_ID);
  }

  public void set_supervisorNum_isSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __SUPERVISORNUM_ISSET_ID, value);
  }

  public int get_totalPortNum() {
    return this.totalPortNum;
  }

  public void set_totalPortNum(int totalPortNum) {
    this.totalPortNum = totalPortNum;
    set_totalPortNum_isSet(true);
  }

  public void unset_totalPortNum() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __TOTALPORTNUM_ISSET_ID);
  }

  /** Returns true if field totalPortNum is set (has been assigned a value) and false otherwise */
  public boolean is_set_totalPortNum() {
    return EncodingUtils.testBit(__isset_bitfield, __TOTALPORTNUM_ISSET_ID);
  }

  public void set_totalPortNum_isSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __TOTALPORTNUM_ISSET_ID, value);
  }

  public int get_usedPortNum() {
    return this.usedPortNum;
  }

  public void set_usedPortNum(int usedPortNum) {
    this.usedPortNum = usedPortNum;
    set_usedPortNum_isSet(true);
  }

  public void unset_usedPortNum() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __USEDPORTNUM_ISSET_ID);
  }

  /** Returns true if field usedPortNum is set (has been assigned a value) and false otherwise */
  public boolean is_set_usedPortNum() {
    return EncodingUtils.testBit(__isset_bitfield, __USEDPORTNUM_ISSET_ID);
  }

  public void set_usedPortNum_isSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __USEDPORTNUM_ISSET_ID, value);
  }

  public int get_freePortNum() {
    return this.freePortNum;
  }

  public void set_freePortNum(int freePortNum) {
    this.freePortNum = freePortNum;
    set_freePortNum_isSet(true);
  }

  public void unset_freePortNum() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __FREEPORTNUM_ISSET_ID);
  }

  /** Returns true if field freePortNum is set (has been assigned a value) and false otherwise */
  public boolean is_set_freePortNum() {
    return EncodingUtils.testBit(__isset_bitfield, __FREEPORTNUM_ISSET_ID);
  }

  public void set_freePortNum_isSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __FREEPORTNUM_ISSET_ID, value);
  }

  public String get_version() {
    return this.version;
  }

  public void set_version(String version) {
    this.version = version;
  }

  public void unset_version() {
    this.version = null;
  }

  /** Returns true if field version is set (has been assigned a value) and false otherwise */
  public boolean is_set_version() {
    return this.version != null;
  }

  public void set_version_isSet(boolean value) {
    if (!value) {
      this.version = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case NIMBUS_MASTER:
      if (value == null) {
        unset_nimbusMaster();
      } else {
        set_nimbusMaster((NimbusStat)value);
      }
      break;

    case NIMBUS_SLAVES:
      if (value == null) {
        unset_nimbusSlaves();
      } else {
        set_nimbusSlaves((List<NimbusStat>)value);
      }
      break;

    case SUPERVISOR_NUM:
      if (value == null) {
        unset_supervisorNum();
      } else {
        set_supervisorNum((Integer)value);
      }
      break;

    case TOTAL_PORT_NUM:
      if (value == null) {
        unset_totalPortNum();
      } else {
        set_totalPortNum((Integer)value);
      }
      break;

    case USED_PORT_NUM:
      if (value == null) {
        unset_usedPortNum();
      } else {
        set_usedPortNum((Integer)value);
      }
      break;

    case FREE_PORT_NUM:
      if (value == null) {
        unset_freePortNum();
      } else {
        set_freePortNum((Integer)value);
      }
      break;

    case VERSION:
      if (value == null) {
        unset_version();
      } else {
        set_version((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case NIMBUS_MASTER:
      return get_nimbusMaster();

    case NIMBUS_SLAVES:
      return get_nimbusSlaves();

    case SUPERVISOR_NUM:
      return Integer.valueOf(get_supervisorNum());

    case TOTAL_PORT_NUM:
      return Integer.valueOf(get_totalPortNum());

    case USED_PORT_NUM:
      return Integer.valueOf(get_usedPortNum());

    case FREE_PORT_NUM:
      return Integer.valueOf(get_freePortNum());

    case VERSION:
      return get_version();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case NIMBUS_MASTER:
      return is_set_nimbusMaster();
    case NIMBUS_SLAVES:
      return is_set_nimbusSlaves();
    case SUPERVISOR_NUM:
      return is_set_supervisorNum();
    case TOTAL_PORT_NUM:
      return is_set_totalPortNum();
    case USED_PORT_NUM:
      return is_set_usedPortNum();
    case FREE_PORT_NUM:
      return is_set_freePortNum();
    case VERSION:
      return is_set_version();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof NimbusSummary)
      return this.equals((NimbusSummary)that);
    return false;
  }

  public boolean equals(NimbusSummary that) {
    if (that == null)
      return false;

    boolean this_present_nimbusMaster = true && this.is_set_nimbusMaster();
    boolean that_present_nimbusMaster = true && that.is_set_nimbusMaster();
    if (this_present_nimbusMaster || that_present_nimbusMaster) {
      if (!(this_present_nimbusMaster && that_present_nimbusMaster))
        return false;
      if (!this.nimbusMaster.equals(that.nimbusMaster))
        return false;
    }

    boolean this_present_nimbusSlaves = true && this.is_set_nimbusSlaves();
    boolean that_present_nimbusSlaves = true && that.is_set_nimbusSlaves();
    if (this_present_nimbusSlaves || that_present_nimbusSlaves) {
      if (!(this_present_nimbusSlaves && that_present_nimbusSlaves))
        return false;
      if (!this.nimbusSlaves.equals(that.nimbusSlaves))
        return false;
    }

    boolean this_present_supervisorNum = true;
    boolean that_present_supervisorNum = true;
    if (this_present_supervisorNum || that_present_supervisorNum) {
      if (!(this_present_supervisorNum && that_present_supervisorNum))
        return false;
      if (this.supervisorNum != that.supervisorNum)
        return false;
    }

    boolean this_present_totalPortNum = true;
    boolean that_present_totalPortNum = true;
    if (this_present_totalPortNum || that_present_totalPortNum) {
      if (!(this_present_totalPortNum && that_present_totalPortNum))
        return false;
      if (this.totalPortNum != that.totalPortNum)
        return false;
    }

    boolean this_present_usedPortNum = true;
    boolean that_present_usedPortNum = true;
    if (this_present_usedPortNum || that_present_usedPortNum) {
      if (!(this_present_usedPortNum && that_present_usedPortNum))
        return false;
      if (this.usedPortNum != that.usedPortNum)
        return false;
    }

    boolean this_present_freePortNum = true;
    boolean that_present_freePortNum = true;
    if (this_present_freePortNum || that_present_freePortNum) {
      if (!(this_present_freePortNum && that_present_freePortNum))
        return false;
      if (this.freePortNum != that.freePortNum)
        return false;
    }

    boolean this_present_version = true && this.is_set_version();
    boolean that_present_version = true && that.is_set_version();
    if (this_present_version || that_present_version) {
      if (!(this_present_version && that_present_version))
        return false;
      if (!this.version.equals(that.version))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_nimbusMaster = true && (is_set_nimbusMaster());
    list.add(present_nimbusMaster);
    if (present_nimbusMaster)
      list.add(nimbusMaster);

    boolean present_nimbusSlaves = true && (is_set_nimbusSlaves());
    list.add(present_nimbusSlaves);
    if (present_nimbusSlaves)
      list.add(nimbusSlaves);

    boolean present_supervisorNum = true;
    list.add(present_supervisorNum);
    if (present_supervisorNum)
      list.add(supervisorNum);

    boolean present_totalPortNum = true;
    list.add(present_totalPortNum);
    if (present_totalPortNum)
      list.add(totalPortNum);

    boolean present_usedPortNum = true;
    list.add(present_usedPortNum);
    if (present_usedPortNum)
      list.add(usedPortNum);

    boolean present_freePortNum = true;
    list.add(present_freePortNum);
    if (present_freePortNum)
      list.add(freePortNum);

    boolean present_version = true && (is_set_version());
    list.add(present_version);
    if (present_version)
      list.add(version);

    return list.hashCode();
  }

  @Override
  public int compareTo(NimbusSummary other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(is_set_nimbusMaster()).compareTo(other.is_set_nimbusMaster());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (is_set_nimbusMaster()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.nimbusMaster, other.nimbusMaster);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(is_set_nimbusSlaves()).compareTo(other.is_set_nimbusSlaves());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (is_set_nimbusSlaves()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.nimbusSlaves, other.nimbusSlaves);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(is_set_supervisorNum()).compareTo(other.is_set_supervisorNum());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (is_set_supervisorNum()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.supervisorNum, other.supervisorNum);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(is_set_totalPortNum()).compareTo(other.is_set_totalPortNum());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (is_set_totalPortNum()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.totalPortNum, other.totalPortNum);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(is_set_usedPortNum()).compareTo(other.is_set_usedPortNum());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (is_set_usedPortNum()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.usedPortNum, other.usedPortNum);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(is_set_freePortNum()).compareTo(other.is_set_freePortNum());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (is_set_freePortNum()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.freePortNum, other.freePortNum);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(is_set_version()).compareTo(other.is_set_version());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (is_set_version()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.version, other.version);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("NimbusSummary(");
    boolean first = true;

    sb.append("nimbusMaster:");
    if (this.nimbusMaster == null) {
      sb.append("null");
    } else {
      sb.append(this.nimbusMaster);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("nimbusSlaves:");
    if (this.nimbusSlaves == null) {
      sb.append("null");
    } else {
      sb.append(this.nimbusSlaves);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("supervisorNum:");
    sb.append(this.supervisorNum);
    first = false;
    if (!first) sb.append(", ");
    sb.append("totalPortNum:");
    sb.append(this.totalPortNum);
    first = false;
    if (!first) sb.append(", ");
    sb.append("usedPortNum:");
    sb.append(this.usedPortNum);
    first = false;
    if (!first) sb.append(", ");
    sb.append("freePortNum:");
    sb.append(this.freePortNum);
    first = false;
    if (!first) sb.append(", ");
    sb.append("version:");
    if (this.version == null) {
      sb.append("null");
    } else {
      sb.append(this.version);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (!is_set_nimbusMaster()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'nimbusMaster' is unset! Struct:" + toString());
    }

    if (!is_set_nimbusSlaves()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'nimbusSlaves' is unset! Struct:" + toString());
    }

    if (!is_set_supervisorNum()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'supervisorNum' is unset! Struct:" + toString());
    }

    if (!is_set_totalPortNum()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'totalPortNum' is unset! Struct:" + toString());
    }

    if (!is_set_usedPortNum()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'usedPortNum' is unset! Struct:" + toString());
    }

    if (!is_set_freePortNum()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'freePortNum' is unset! Struct:" + toString());
    }

    if (!is_set_version()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'version' is unset! Struct:" + toString());
    }

    // check for sub-struct validity
    if (nimbusMaster != null) {
      nimbusMaster.validate();
    }
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class NimbusSummaryStandardSchemeFactory implements SchemeFactory {
    public NimbusSummaryStandardScheme getScheme() {
      return new NimbusSummaryStandardScheme();
    }
  }

  private static class NimbusSummaryStandardScheme extends StandardScheme<NimbusSummary> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, NimbusSummary struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // NIMBUS_MASTER
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.nimbusMaster = new NimbusStat();
              struct.nimbusMaster.read(iprot);
              struct.set_nimbusMaster_isSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // NIMBUS_SLAVES
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list74 = iprot.readListBegin();
                struct.nimbusSlaves = new ArrayList<NimbusStat>(_list74.size);
                NimbusStat _elem75;
                for (int _i76 = 0; _i76 < _list74.size; ++_i76)
                {
                  _elem75 = new NimbusStat();
                  _elem75.read(iprot);
                  struct.nimbusSlaves.add(_elem75);
                }
                iprot.readListEnd();
              }
              struct.set_nimbusSlaves_isSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // SUPERVISOR_NUM
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.supervisorNum = iprot.readI32();
              struct.set_supervisorNum_isSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // TOTAL_PORT_NUM
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.totalPortNum = iprot.readI32();
              struct.set_totalPortNum_isSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // USED_PORT_NUM
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.usedPortNum = iprot.readI32();
              struct.set_usedPortNum_isSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // FREE_PORT_NUM
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.freePortNum = iprot.readI32();
              struct.set_freePortNum_isSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 7: // VERSION
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.version = iprot.readString();
              struct.set_version_isSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, NimbusSummary struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.nimbusMaster != null) {
        oprot.writeFieldBegin(NIMBUS_MASTER_FIELD_DESC);
        struct.nimbusMaster.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.nimbusSlaves != null) {
        oprot.writeFieldBegin(NIMBUS_SLAVES_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.nimbusSlaves.size()));
          for (NimbusStat _iter77 : struct.nimbusSlaves)
          {
            _iter77.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(SUPERVISOR_NUM_FIELD_DESC);
      oprot.writeI32(struct.supervisorNum);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(TOTAL_PORT_NUM_FIELD_DESC);
      oprot.writeI32(struct.totalPortNum);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(USED_PORT_NUM_FIELD_DESC);
      oprot.writeI32(struct.usedPortNum);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(FREE_PORT_NUM_FIELD_DESC);
      oprot.writeI32(struct.freePortNum);
      oprot.writeFieldEnd();
      if (struct.version != null) {
        oprot.writeFieldBegin(VERSION_FIELD_DESC);
        oprot.writeString(struct.version);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class NimbusSummaryTupleSchemeFactory implements SchemeFactory {
    public NimbusSummaryTupleScheme getScheme() {
      return new NimbusSummaryTupleScheme();
    }
  }

  private static class NimbusSummaryTupleScheme extends TupleScheme<NimbusSummary> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, NimbusSummary struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      struct.nimbusMaster.write(oprot);
      {
        oprot.writeI32(struct.nimbusSlaves.size());
        for (NimbusStat _iter78 : struct.nimbusSlaves)
        {
          _iter78.write(oprot);
        }
      }
      oprot.writeI32(struct.supervisorNum);
      oprot.writeI32(struct.totalPortNum);
      oprot.writeI32(struct.usedPortNum);
      oprot.writeI32(struct.freePortNum);
      oprot.writeString(struct.version);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, NimbusSummary struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.nimbusMaster = new NimbusStat();
      struct.nimbusMaster.read(iprot);
      struct.set_nimbusMaster_isSet(true);
      {
        org.apache.thrift.protocol.TList _list79 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
        struct.nimbusSlaves = new ArrayList<NimbusStat>(_list79.size);
        NimbusStat _elem80;
        for (int _i81 = 0; _i81 < _list79.size; ++_i81)
        {
          _elem80 = new NimbusStat();
          _elem80.read(iprot);
          struct.nimbusSlaves.add(_elem80);
        }
      }
      struct.set_nimbusSlaves_isSet(true);
      struct.supervisorNum = iprot.readI32();
      struct.set_supervisorNum_isSet(true);
      struct.totalPortNum = iprot.readI32();
      struct.set_totalPortNum_isSet(true);
      struct.usedPortNum = iprot.readI32();
      struct.set_usedPortNum_isSet(true);
      struct.freePortNum = iprot.readI32();
      struct.set_freePortNum_isSet(true);
      struct.version = iprot.readString();
      struct.set_version_isSet(true);
    }
  }

}


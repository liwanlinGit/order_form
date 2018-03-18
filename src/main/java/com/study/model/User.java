package com.study.model;

import javax.persistence.*;

import java.io.Serializable;
public class User implements Serializable{
    private static final long serialVersionUID = -8736616045315083846L;

    // 主键由数据库自动生成（主要是自动增长型）
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private String password;

    /**
     * 是否启用
     */
    private Integer enable;
    
    private String name;
    private String address;
    private String mark;
    private String phone;
    /**
     * 所属店
     */
    private Integer store;
    @Transient
    private String storeName;
    /**
     * 联系电话
     */
    @Column(name = "contact_number")
    private String contactNumber;
    
    /**
     * 联系人
     */
    private String contact;
    
    /**
     * s所属区域
     */
    @Column(name = "contact_address")
    private Integer contactAddress;
    
    @Transient
    private String contactAddressName;
    @Column(name = "dept_id")
    private Integer deptId;
    
    @Transient
    private String deptName;

    public String getDeptName() {
      return deptName;
    }

    public void setDeptName(String deptName) {
      this.deptName = deptName;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getAddress() {
      return address;
    }

    public void setAddress(String address) {
      this.address = address;
    }

    public String getMark() {
      return mark;
    }

    public void setMark(String mark) {
      this.mark = mark;
    }

    public String getPhone() {
      return phone;
    }

    public void setPhone(String phone) {
      this.phone = phone;
    }

    public Integer getDeptId() {
      return deptId;
    }

    public void setDeptId(Integer deptId) {
      this.deptId = deptId;
    }

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取是否启用
     *
     * @return enable - 是否启用
     */
    public Integer getEnable() {
        return enable;
    }

    /**
     * 设置是否启用
     *
     * @param enable 是否启用
     */
    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public Integer getStore() {
      return store;
    }

    public void setStore(Integer store) {
      this.store = store;
    }

    public String getStoreName() {
      return storeName;
    }

    public void setStoreName(String storeName) {
      this.storeName = storeName;
    }

    public String getContactNumber() {
      return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
      this.contactNumber = contactNumber;
    }

    public String getContact() {
      return contact;
    }

    public void setContact(String contact) {
      this.contact = contact;
    }


    public Integer getContactAddress() {
      return contactAddress;
    }

    public void setContactAddress(Integer contactAddress) {
      this.contactAddress = contactAddress;
    }

    public String getContactAddressName() {
      return contactAddressName;
    }

    public void setContactAddressName(String contactAddressName) {
      this.contactAddressName = contactAddressName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enable=" + enable +
                '}';
    }
}
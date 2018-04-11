package com.study.model;

import javax.persistence.*;
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "order_id")
    private Integer orderId;

    /**
     * 公司名称
     */
    @Column(name = "order_company")
    private String orderCompany;

    /**
     * 公司电话
     */
    @Column(name = "order_company_phone")
    private String orderCompanyPhone;

    /**
     * 公司传真
     */
    @Column(name = "order_company_fax")
    private String orderCompanyFax;

    /**
     * 公司网址
     */
    @Column(name = "order_company_website")
    private String orderCompanyWebsite;

    /**
     * 订货日期
     */
    @Column(name = "order_date")
    private String orderDate;

    /**
     * 价格组
     */
    @Column(name = "order_price_group")
    private String orderPriceGroup;

    /**
     * 客户单号
     */
    @Column(name = "order_number")
    private String orderNumber;

    /**
     * 是否加急 1是、0否
     */
    @Column(name = "order_urgent")
    private Integer orderUrgent;

    /**
     * 销售员
     */
    @Column(name = "order_seller")
    private String orderSeller;

    /**
     * 交货日期
     */
    @Column(name = "order_delivery_date")
    private String orderDeliveryDate;

    /**
     * 客户姓名
     */
    @Column(name = "order_customer_name")
    private String orderCustomerName;

    /**
     * 合同编号
     */
    @Column(name = "order_contract_number")
    private String orderContractNumber;

    /**
     * 安装日期
     */
    @Column(name = "order_ins_date")
    private String orderInsDate;

    /**
     * 客户手机
     */
    @Column(name = "order_customer_phone")
    private String orderCustomerPhone;

    /**
     * 客户电话
     */
    @Column(name = "order_customer_telephone")
    private String orderCustomerTelephone;

    /**
     * 该管日期
     */
    @Column(name = "order_tube_date")
    private String orderTubeDate;

    /**
     * 联系地址
     */
    @Column(name = "order_address")
    private String orderAddress;

    /**
     * 备注
     */
    @Column(name = "order_remark")
    private String orderRemark;

    /**
     * 附加金额
     */
    @Column(name = "order_additional_amount")
    private Double orderAdditionalAmount;

    /**
     * 附加金额说明
     */
    @Column(name = "order_additional_remark")
    private String orderAdditionalRemark;

    /**
     * 销售金额
     */
    @Column(name = "order_sales_amount")
    private Double orderSalesAmount;

    /**
     * 订货总数
     */
    @Column(name = "order_total")
    private Double orderTotal;

    /**
     * 片数合计
     */
    @Column(name = "order_total_number")
    private Double orderTotalNumber;

    /**
     * 付款
     */
    @Column(name = "order_payment")
    private Double orderPayment;

    /**
     * 保证金
     */
    @Column(name = "order_margin")
    private Double orderMargin;

    /**
     * 应付款总额
     */
    @Column(name = "order_total_payment")
    private Double orderTotalPayment;

    /**
     * 可用余额
     */
    @Column(name = "order_available_balance")
    private Double orderAvailableBalance;

    /**
     * 信用额度
     */
    @Column(name = "order_credits")
    private Double orderCredits;

    /**
     * 订货时间
     */
    @Column(name = "order_time")
    private String orderTime;

    /**
     * 交货时间
     */
    @Column(name = "order_delivery_time")
    private String orderDeliveryTime;

    /**
     * 订单状态
     */
    @Column(name = "order_status")
    private String orderStatus;

    /**
     * 订单审核人
     */
    @Column(name = "order_review")
    private String orderReview;

    /**
     * 订单审核时间
     */
    @Column(name = "order_review_time")
    private String orderReviewTime;

    /**
     * 财务审核人
     */
    @Column(name = "order_financial_audit")
    private String orderFinancialAudit;

    /**
     * 财务审核时间
     */
    @Column(name = "order_financial_audit_time")
    private String orderFinancialAuditTime;

    /**
     * 制单
     */
    @Column(name = "order_single")
    private String orderSingle;

    /**
     * 制单时间
     */
    @Column(name = "order_single_time")
    private String orderSingleTime;

    /**
     * 经销商
     */
    @Column(name = "order_dealer")
    private String orderDealer;
    
    @Column(name = "order_dealer_name")
    private String orderDealerName;

    /**
     * 类型 1返货，0退货
     */
    @Column(name = "order_type")
    private Integer orderType;

    /**
     * 客户分类
     */
    @Column(name = "order_customer_type")
    private String orderCustomerType;

    /**
     * 所属区域
     */
    @Column(name = "order_customer_address")
    private String orderCustomerAddress;

    /**
     * 联系人
     */
    @Column(name = "order_contact")
    private String orderContact;

    /**
     * 联系电话
     */
    @Column(name = "order_contact_phone")
    private String orderContactPhone;

    /**
     * 联系人传真
     */
    @Column(name = "order_contact_fax")
    private String orderContactFax;

    
    @Column(name = "order_single_name")
    private String orderSingleName;
    
    @Transient
    private String contactAddressName;
    @Transient
    private String contactNumber;
    @Transient
    private String contact;
    @Transient
    private String storeName;
    
    @Transient
    private String orderReviewName;
    
    @Transient
    private String beginTime;
    @Transient
    private String endTime;
    
    
    
    public String getBeginTime() {
      return beginTime;
    }

    public void setBeginTime(String beginTime) {
      this.beginTime = beginTime;
    }

    public String getEndTime() {
      return endTime;
    }

    public void setEndTime(String endTime) {
      this.endTime = endTime;
    }

    public String getOrderReviewName() {
      return orderReviewName;
    }

    public void setOrderReviewName(String orderReviewName) {
      this.orderReviewName = orderReviewName;
    }

    /**
     * @return order_id
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * @param orderId
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取公司名称
     *
     * @return order_company - 公司名称
     */
    public String getOrderCompany() {
        return orderCompany;
    }

    /**
     * 设置公司名称
     *
     * @param orderCompany 公司名称
     */
    public void setOrderCompany(String orderCompany) {
        this.orderCompany = orderCompany;
    }

    /**
     * 获取公司电话
     *
     * @return order_company_phone - 公司电话
     */
    public String getOrderCompanyPhone() {
        return orderCompanyPhone;
    }

    /**
     * 设置公司电话
     *
     * @param orderCompanyPhone 公司电话
     */
    public void setOrderCompanyPhone(String orderCompanyPhone) {
        this.orderCompanyPhone = orderCompanyPhone;
    }

    /**
     * 获取公司传真
     *
     * @return order_company_fax - 公司传真
     */
    public String getOrderCompanyFax() {
        return orderCompanyFax;
    }

    /**
     * 设置公司传真
     *
     * @param orderCompanyFax 公司传真
     */
    public void setOrderCompanyFax(String orderCompanyFax) {
        this.orderCompanyFax = orderCompanyFax;
    }

    /**
     * 获取公司网址
     *
     * @return order_company_website - 公司网址
     */
    public String getOrderCompanyWebsite() {
        return orderCompanyWebsite;
    }

    /**
     * 设置公司网址
     *
     * @param orderCompanyWebsite 公司网址
     */
    public void setOrderCompanyWebsite(String orderCompanyWebsite) {
        this.orderCompanyWebsite = orderCompanyWebsite;
    }

    /**
     * 获取订货日期
     *
     * @return order_date - 订货日期
     */
    public String getOrderDate() {
        return orderDate;
    }

    /**
     * 设置订货日期
     *
     * @param orderDate 订货日期
     */
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * 获取价格组
     *
     * @return order_price_group - 价格组
     */
    public String getOrderPriceGroup() {
        return orderPriceGroup;
    }

    /**
     * 设置价格组
     *
     * @param orderPriceGroup 价格组
     */
    public void setOrderPriceGroup(String orderPriceGroup) {
        this.orderPriceGroup = orderPriceGroup;
    }

    /**
     * 获取客户单号
     *
     * @return order_number - 客户单号
     */
    public String getOrderNumber() {
        return orderNumber;
    }

    /**
     * 设置客户单号
     *
     * @param orderNumber 客户单号
     */
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * 获取是否加急 1是、0否
     *
     * @return order_urgent - 是否加急 1是、0否
     */
    public Integer getOrderUrgent() {
        return orderUrgent;
    }

    /**
     * 设置是否加急 1是、0否
     *
     * @param orderUrgent 是否加急 1是、0否
     */
    public void setOrderUrgent(Integer orderUrgent) {
        this.orderUrgent = orderUrgent;
    }

    /**
     * 获取销售员
     *
     * @return order_seller - 销售员
     */
    public String getOrderSeller() {
        return orderSeller;
    }

    /**
     * 设置销售员
     *
     * @param orderSeller 销售员
     */
    public void setOrderSeller(String orderSeller) {
        this.orderSeller = orderSeller;
    }

    /**
     * 获取交货日期
     *
     * @return order_delivery_date - 交货日期
     */
    public String getOrderDeliveryDate() {
        return orderDeliveryDate;
    }

    /**
     * 设置交货日期
     *
     * @param orderDeliveryDate 交货日期
     */
    public void setOrderDeliveryDate(String orderDeliveryDate) {
        this.orderDeliveryDate = orderDeliveryDate;
    }

    /**
     * 获取客户姓名
     *
     * @return order_customer_name - 客户姓名
     */
    public String getOrderCustomerName() {
        return orderCustomerName;
    }

    /**
     * 设置客户姓名
     *
     * @param orderCustomerName 客户姓名
     */
    public void setOrderCustomerName(String orderCustomerName) {
        this.orderCustomerName = orderCustomerName;
    }

    /**
     * 获取合同编号
     *
     * @return order_contract_number - 合同编号
     */
    public String getOrderContractNumber() {
        return orderContractNumber;
    }

    /**
     * 设置合同编号
     *
     * @param orderContractNumber 合同编号
     */
    public void setOrderContractNumber(String orderContractNumber) {
        this.orderContractNumber = orderContractNumber;
    }

    /**
     * 获取安装日期
     *
     * @return order_ins_date - 安装日期
     */
    public String getOrderInsDate() {
        return orderInsDate;
    }

    /**
     * 设置安装日期
     *
     * @param orderInsDate 安装日期
     */
    public void setOrderInsDate(String orderInsDate) {
        this.orderInsDate = orderInsDate;
    }

    /**
     * 获取客户手机
     *
     * @return order_customer_phone - 客户手机
     */
    public String getOrderCustomerPhone() {
        return orderCustomerPhone;
    }

    /**
     * 设置客户手机
     *
     * @param orderCustomerPhone 客户手机
     */
    public void setOrderCustomerPhone(String orderCustomerPhone) {
        this.orderCustomerPhone = orderCustomerPhone;
    }

    /**
     * 获取客户电话
     *
     * @return order_customer_telephone - 客户电话
     */
    public String getOrderCustomerTelephone() {
        return orderCustomerTelephone;
    }

    /**
     * 设置客户电话
     *
     * @param orderCustomerTelephone 客户电话
     */
    public void setOrderCustomerTelephone(String orderCustomerTelephone) {
        this.orderCustomerTelephone = orderCustomerTelephone;
    }

    /**
     * 获取该管日期
     *
     * @return order_tube_date - 该管日期
     */
    public String getOrderTubeDate() {
        return orderTubeDate;
    }

    /**
     * 设置该管日期
     *
     * @param orderTubeDate 该管日期
     */
    public void setOrderTubeDate(String orderTubeDate) {
        this.orderTubeDate = orderTubeDate;
    }

    /**
     * 获取联系地址
     *
     * @return order_address - 联系地址
     */
    public String getOrderAddress() {
        return orderAddress;
    }

    /**
     * 设置联系地址
     *
     * @param orderAddress 联系地址
     */
    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    /**
     * 获取备注
     *
     * @return order_remark - 备注
     */
    public String getOrderRemark() {
        return orderRemark;
    }

    /**
     * 设置备注
     *
     * @param orderRemark 备注
     */
    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark;
    }

    /**
     * 获取附加金额
     *
     * @return order_additional_amount - 附加金额
     */
    public Double getOrderAdditionalAmount() {
        return orderAdditionalAmount;
    }

    /**
     * 设置附加金额
     *
     * @param orderAdditionalAmount 附加金额
     */
    public void setOrderAdditionalAmount(Double orderAdditionalAmount) {
        this.orderAdditionalAmount = orderAdditionalAmount;
    }

    /**
     * 获取附加金额说明
     *
     * @return order_additional_remark - 附加金额说明
     */
    public String getOrderAdditionalRemark() {
        return orderAdditionalRemark;
    }

    /**
     * 设置附加金额说明
     *
     * @param orderAdditionalRemark 附加金额说明
     */
    public void setOrderAdditionalRemark(String orderAdditionalRemark) {
        this.orderAdditionalRemark = orderAdditionalRemark;
    }

    /**
     * 获取销售金额
     *
     * @return order_sales_amount - 销售金额
     */
    public Double getOrderSalesAmount() {
        return orderSalesAmount;
    }

    /**
     * 设置销售金额
     *
     * @param orderSalesAmount 销售金额
     */
    public void setOrderSalesAmount(Double orderSalesAmount) {
        this.orderSalesAmount = orderSalesAmount;
    }

    /**
     * 获取订货总数
     *
     * @return order_total - 订货总数
     */
    public Double getOrderTotal() {
        return orderTotal;
    }

    /**
     * 设置订货总数
     *
     * @param orderTotal 订货总数
     */
    public void setOrderTotal(Double orderTotal) {
        this.orderTotal = orderTotal;
    }

    /**
     * 获取片数合计
     *
     * @return order_total_number - 片数合计
     */
    public Double getOrderTotalNumber() {
        return orderTotalNumber;
    }

    /**
     * 设置片数合计
     *
     * @param orderTotalNumber 片数合计
     */
    public void setOrderTotalNumber(Double orderTotalNumber) {
        this.orderTotalNumber = orderTotalNumber;
    }

    /**
     * 获取付款
     *
     * @return order_payment - 付款
     */
    public Double getOrderPayment() {
        return orderPayment;
    }

    /**
     * 设置付款
     *
     * @param orderPayment 付款
     */
    public void setOrderPayment(Double orderPayment) {
        this.orderPayment = orderPayment;
    }

    /**
     * 获取保证金
     *
     * @return order_margin - 保证金
     */
    public Double getOrderMargin() {
        return orderMargin;
    }

    /**
     * 设置保证金
     *
     * @param orderMargin 保证金
     */
    public void setOrderMargin(Double orderMargin) {
        this.orderMargin = orderMargin;
    }

    /**
     * 获取应付款总额
     *
     * @return order_total_payment - 应付款总额
     */
    public Double getOrderTotalPayment() {
        return orderTotalPayment;
    }

    /**
     * 设置应付款总额
     *
     * @param orderTotalPayment 应付款总额
     */
    public void setOrderTotalPayment(Double orderTotalPayment) {
        this.orderTotalPayment = orderTotalPayment;
    }

    /**
     * 获取可用余额
     *
     * @return order_available_balance - 可用余额
     */
    public Double getOrderAvailableBalance() {
        return orderAvailableBalance;
    }

    /**
     * 设置可用余额
     *
     * @param orderAvailableBalance 可用余额
     */
    public void setOrderAvailableBalance(Double orderAvailableBalance) {
        this.orderAvailableBalance = orderAvailableBalance;
    }

    /**
     * 获取信用额度
     *
     * @return order_credits - 信用额度
     */
    public Double getOrderCredits() {
        return orderCredits;
    }

    /**
     * 设置信用额度
     *
     * @param orderCredits 信用额度
     */
    public void setOrderCredits(Double orderCredits) {
        this.orderCredits = orderCredits;
    }

    /**
     * 获取订货时间
     *
     * @return order_time - 订货时间
     */
    public String getOrderTime() {
        return orderTime;
    }

    /**
     * 设置订货时间
     *
     * @param orderTime 订货时间
     */
    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    /**
     * 获取交货时间
     *
     * @return order_delivery_time - 交货时间
     */
    public String getOrderDeliveryTime() {
        return orderDeliveryTime;
    }

    /**
     * 设置交货时间
     *
     * @param orderDeliveryTime 交货时间
     */
    public void setOrderDeliveryTime(String orderDeliveryTime) {
        this.orderDeliveryTime = orderDeliveryTime;
    }

    /**
     * 获取订单状态
     *
     * @return order_status - 订单状态
     */
    public String getOrderStatus() {
        return orderStatus;
    }

    /**
     * 设置订单状态
     *
     * @param orderStatus 订单状态
     */
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * 获取订单审核人
     *
     * @return order_review - 订单审核人
     */
    public String getOrderReview() {
        return orderReview;
    }

    /**
     * 设置订单审核人
     *
     * @param orderReview 订单审核人
     */
    public void setOrderReview(String orderReview) {
        this.orderReview = orderReview;
    }

    /**
     * 获取订单审核时间
     *
     * @return order_review_time - 订单审核时间
     */
    public String getOrderReviewTime() {
        return orderReviewTime;
    }

    /**
     * 设置订单审核时间
     *
     * @param orderReviewTime 订单审核时间
     */
    public void setOrderReviewTime(String orderReviewTime) {
        this.orderReviewTime = orderReviewTime;
    }

    /**
     * 获取财务审核人
     *
     * @return order_financial_audit - 财务审核人
     */
    public String getOrderFinancialAudit() {
        return orderFinancialAudit;
    }

    /**
     * 设置财务审核人
     *
     * @param orderFinancialAudit 财务审核人
     */
    public void setOrderFinancialAudit(String orderFinancialAudit) {
        this.orderFinancialAudit = orderFinancialAudit;
    }

    /**
     * 获取财务审核时间
     *
     * @return order_financial_audit_time - 财务审核时间
     */
    public String getOrderFinancialAuditTime() {
        return orderFinancialAuditTime;
    }

    /**
     * 设置财务审核时间
     *
     * @param orderFinancialAuditTime 财务审核时间
     */
    public void setOrderFinancialAuditTime(String orderFinancialAuditTime) {
        this.orderFinancialAuditTime = orderFinancialAuditTime;
    }

    /**
     * 获取制单
     *
     * @return order_single - 制单
     */
    public String getOrderSingle() {
        return orderSingle;
    }

    /**
     * 设置制单
     *
     * @param orderSingle 制单
     */
    public void setOrderSingle(String orderSingle) {
        this.orderSingle = orderSingle;
    }

    /**
     * 获取制单时间
     *
     * @return order_single_time - 制单时间
     */
    public String getOrderSingleTime() {
        return orderSingleTime;
    }

    /**
     * 设置制单时间
     *
     * @param orderSingleTime 制单时间
     */
    public void setOrderSingleTime(String orderSingleTime) {
        this.orderSingleTime = orderSingleTime;
    }

    /**
     * 获取经销商
     *
     * @return order_dealer - 经销商
     */
    public String getOrderDealer() {
        return orderDealer;
    }

    /**
     * 设置经销商
     *
     * @param orderDealer 经销商
     */
    public void setOrderDealer(String orderDealer) {
        this.orderDealer = orderDealer;
    }

    /**
     * 获取类型 1返货，0退货
     *
     * @return order_type - 类型 1返货，0退货
     */
    public Integer getOrderType() {
        return orderType;
    }

    /**
     * 设置类型 1返货，0退货
     *
     * @param orderType 类型 1返货，0退货
     */
    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    /**
     * 获取客户分类
     *
     * @return order_customer_type - 客户分类
     */
    public String getOrderCustomerType() {
        return orderCustomerType;
    }

    /**
     * 设置客户分类
     *
     * @param orderCustomerType 客户分类
     */
    public void setOrderCustomerType(String orderCustomerType) {
        this.orderCustomerType = orderCustomerType;
    }

    /**
     * 获取所属区域
     *
     * @return order_customer_address - 所属区域
     */
    public String getOrderCustomerAddress() {
        return orderCustomerAddress;
    }

    /**
     * 设置所属区域
     *
     * @param orderCustomerAddress 所属区域
     */
    public void setOrderCustomerAddress(String orderCustomerAddress) {
        this.orderCustomerAddress = orderCustomerAddress;
    }

    /**
     * 获取联系人
     *
     * @return order_contact - 联系人
     */
    public String getOrderContact() {
        return orderContact;
    }

    /**
     * 设置联系人
     *
     * @param orderContact 联系人
     */
    public void setOrderContact(String orderContact) {
        this.orderContact = orderContact;
    }

    /**
     * 获取联系电话
     *
     * @return order_contact_phone - 联系电话
     */
    public String getOrderContactPhone() {
        return orderContactPhone;
    }

    /**
     * 设置联系电话
     *
     * @param orderContactPhone 联系电话
     */
    public void setOrderContactPhone(String orderContactPhone) {
        this.orderContactPhone = orderContactPhone;
    }

    /**
     * 获取联系人传真
     *
     * @return order_contact_fax - 联系人传真
     */
    public String getOrderContactFax() {
        return orderContactFax;
    }

    /**
     * 设置联系人传真
     *
     * @param orderContactFax 联系人传真
     */
    public void setOrderContactFax(String orderContactFax) {
        this.orderContactFax = orderContactFax;
    }

    public String getOrderDealerName() {
      return orderDealerName;
    }

    public void setOrderDealerName(String orderDealerName) {
      this.orderDealerName = orderDealerName;
    }

    public String getOrderSingleName() {
      return orderSingleName;
    }

    public void setOrderSingleName(String orderSingleName) {
      this.orderSingleName = orderSingleName;
    }

    public String getContactAddressName() {
      return contactAddressName;
    }

    public void setContactAddressName(String contactAddressName) {
      this.contactAddressName = contactAddressName;
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

    public String getStoreName() {
      return storeName;
    }

    public void setStoreName(String storeName) {
      this.storeName = storeName;
    }
    
    
}
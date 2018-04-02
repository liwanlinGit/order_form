package com.study.model.vo;


public class OrderDetailVo {
  private Integer orderId;

  /**
   * 公司名称
   */
  private String orderCompany;

  /**
   * 公司电话
   */
  private String orderCompanyPhone;

  /**
   * 公司传真
   */
  private String orderCompanyFax;

  /**
   * 公司网址
   */
  private String orderCompanyWebsite;

  /**
   * 订货日期
   */
  private String orderDate;

  /**
   * 价格组
   */
  private String orderPriceGroup;

  /**
   * 客户单号
   */
  private String orderNumber;

  /**
   * 是否加急 1是、0否
   */
  private Integer orderUrgent;

  /**
   * 销售员
   */
  private String orderSeller;

  /**
   * 交货日期
   */
  private String orderDeliveryDate;

  /**
   * 客户姓名
   */
  private String orderCustomerName;

  /**
   * 合同编号
   */
  private String orderContractNumber;

  /**
   * 安装日期
   */
  private String orderInsDate;

  /**
   * 客户手机
   */
  private String orderCustomerPhone;

  /**
   * 客户电话
   */
  private String orderCustomerTelephone;

  /**
   * 该管日期
   */
  private String orderTubeDate;

  /**
   * 联系地址
   */
  private String orderAddress;

  /**
   * 备注
   */
  private String orderRemark;

  /**
   * 附加金额
   */
  private Double orderAdditionalAmount;

  /**
   * 附加金额说明
   */
  private String orderAdditionalRemark;

  /**
   * 销售金额
   */
  private Double orderSalesAmount;

  /**
   * 订货总数
   */
  private Double orderTotal;

  /**
   * 片数合计
   */
  private Double orderTotalNumber;

  /**
   * 付款
   */
  private Double orderPayment;

  /**
   * 保证金
   */
  private Double orderMargin;

  /**
   * 应付款总额
   */
  private Double orderTotalPayment;

  /**
   * 可用余额
   */
  private Double orderAvailableBalance;

  /**
   * 信用额度
   */
  private Double orderCredits;

  /**
   * 订货时间
   */
  private String orderTime;

  /**
   * 交货时间
   */
  private String orderDeliveryTime;

  /**
   * 订单状态
   */
  private String orderStatus;

  /**
   * 订单审核人
   */
  private String orderReview;

  /**
   * 订单审核时间
   */
  private String orderReviewTime;

  /**
   * 财务审核人
   */
  private String orderFinancialAudit;

  /**
   * 财务审核时间
   */
  private String orderFinancialAuditTime;

  /**
   * 制单
   */
  private String orderSingle;

  /**
   * 制单时间
   */
  private String orderSingleTime;

  /**
   * 经销商
   */
  private String orderDealer;
  
  private String orderDealerName;

  /**
   * 类型 1返货，0退货
   */
  private Integer orderType;

  /**
   * 客户分类
   */
  private String orderCustomerType;

  /**
   * 所属区域
   */
  private String orderCustomerAddress;

  /**
   * 联系人
   */
  private String orderContact;

  /**
   * 联系电话
   */
  private String orderContactPhone;

  /**
   * 联系人传真
   */
  private String orderContactFax;

  
  private String orderSingleName;
  
  private String contactAddressName;
  private String contactNumber;
  private String contact;
  private String storeName;
  
  private String orderReviewName;
  
  private String beginTime;
  private String endTime;
  
  private Integer detailId;

  /**
   * 系列
   */
  private String detailSeries;
  private String detailSeriesName;

  /**
   * 型号
   */
  private String detailModel;
  private String detailModelName;

  /**
   * 组数
   */
  private Integer detailNumberGroup;

  /**
   * 片数
   */
  private Integer detailNumber;

  /**
   * 片数小计
   */
  private Integer detailTotalNumber;

  /**
   * 房间
   */
  private String detailRoom;

  /**
   * 高
   */
  private Double detailHight;

  /**
   * 宽
   */
  private Double detailWidth;

  /**
   * 单位
   */
  private String detailUnit;

  /**
   * 颜色
   */
  private String detailColor;

  /**
   * 进水方式
   */
  private String detailWaterType;

  /**
   * 中心距
   */
  private String detailCenterDistance;

  /**
   * 接口口径
   */
  private String detailInterfaceCaliber;

  /**
   * 市场单价
   */
  private Double detailMarketPrice;

  /**
   * 市场价金额
   */
  private Double detailMarketPriceAmount;

  /**
   * 市场零售价
   */
  private Double detailMarketRetailPrice;

  /**
   * 市场零售金额
   */
  private Double detailMarketRetailPriceAmount;

  /**
   * 定制费单价
   */
  private String detailCustomFee;

  /**
   * 定制费小计
   */
  private Double detailTotalCustomFee;

  /**
   * 应生产量
   */
  private Double detailShouldProduce;

  /**
   * 发货时间
   */
  private String detailDeliveryTime;

  /**
   * 备注
   */
  private String detailRemark;

  /**
   * 订单状态
   */
  private String detailOrderStatus;

  /**
   * 生产状态
   */
  private String detailGeneratedStatus;
  
  /**
   * 单价
   */
  private Double detailPrice;
  
  /**
   * 金额
   */
  private Double detailMoney;
  
  private String detailColorName;
  private String detailWaterTypeName;
  private String detailCenterDistanceName;
  private String detailInterfaceCaliberName;
  private String detailCustomFeeName;
  public Integer getOrderId() {
    return orderId;
  }
  public void setOrderId(Integer orderId) {
    this.orderId = orderId;
  }
  public String getOrderCompany() {
    return orderCompany;
  }
  public void setOrderCompany(String orderCompany) {
    this.orderCompany = orderCompany;
  }
  public String getOrderCompanyPhone() {
    return orderCompanyPhone;
  }
  public void setOrderCompanyPhone(String orderCompanyPhone) {
    this.orderCompanyPhone = orderCompanyPhone;
  }
  public String getOrderCompanyFax() {
    return orderCompanyFax;
  }
  public void setOrderCompanyFax(String orderCompanyFax) {
    this.orderCompanyFax = orderCompanyFax;
  }
  public String getOrderCompanyWebsite() {
    return orderCompanyWebsite;
  }
  public void setOrderCompanyWebsite(String orderCompanyWebsite) {
    this.orderCompanyWebsite = orderCompanyWebsite;
  }
  public String getOrderDate() {
    return orderDate;
  }
  public void setOrderDate(String orderDate) {
    this.orderDate = orderDate;
  }
  public String getOrderPriceGroup() {
    return orderPriceGroup;
  }
  public void setOrderPriceGroup(String orderPriceGroup) {
    this.orderPriceGroup = orderPriceGroup;
  }
  public String getOrderNumber() {
    return orderNumber;
  }
  public void setOrderNumber(String orderNumber) {
    this.orderNumber = orderNumber;
  }
  public Integer getOrderUrgent() {
    return orderUrgent;
  }
  public void setOrderUrgent(Integer orderUrgent) {
    this.orderUrgent = orderUrgent;
  }
  public String getOrderSeller() {
    return orderSeller;
  }
  public void setOrderSeller(String orderSeller) {
    this.orderSeller = orderSeller;
  }
  public String getOrderDeliveryDate() {
    return orderDeliveryDate;
  }
  public void setOrderDeliveryDate(String orderDeliveryDate) {
    this.orderDeliveryDate = orderDeliveryDate;
  }
  public String getOrderCustomerName() {
    return orderCustomerName;
  }
  public void setOrderCustomerName(String orderCustomerName) {
    this.orderCustomerName = orderCustomerName;
  }
  public String getOrderContractNumber() {
    return orderContractNumber;
  }
  public void setOrderContractNumber(String orderContractNumber) {
    this.orderContractNumber = orderContractNumber;
  }
  public String getOrderInsDate() {
    return orderInsDate;
  }
  public void setOrderInsDate(String orderInsDate) {
    this.orderInsDate = orderInsDate;
  }
  public String getOrderCustomerPhone() {
    return orderCustomerPhone;
  }
  public void setOrderCustomerPhone(String orderCustomerPhone) {
    this.orderCustomerPhone = orderCustomerPhone;
  }
  public String getOrderCustomerTelephone() {
    return orderCustomerTelephone;
  }
  public void setOrderCustomerTelephone(String orderCustomerTelephone) {
    this.orderCustomerTelephone = orderCustomerTelephone;
  }
  public String getOrderTubeDate() {
    return orderTubeDate;
  }
  public void setOrderTubeDate(String orderTubeDate) {
    this.orderTubeDate = orderTubeDate;
  }
  public String getOrderAddress() {
    return orderAddress;
  }
  public void setOrderAddress(String orderAddress) {
    this.orderAddress = orderAddress;
  }
  public String getOrderRemark() {
    return orderRemark;
  }
  public void setOrderRemark(String orderRemark) {
    this.orderRemark = orderRemark;
  }
  public Double getOrderAdditionalAmount() {
    return orderAdditionalAmount;
  }
  public void setOrderAdditionalAmount(Double orderAdditionalAmount) {
    this.orderAdditionalAmount = orderAdditionalAmount;
  }
  public String getOrderAdditionalRemark() {
    return orderAdditionalRemark;
  }
  public void setOrderAdditionalRemark(String orderAdditionalRemark) {
    this.orderAdditionalRemark = orderAdditionalRemark;
  }
  public Double getOrderSalesAmount() {
    return orderSalesAmount;
  }
  public void setOrderSalesAmount(Double orderSalesAmount) {
    this.orderSalesAmount = orderSalesAmount;
  }
  public Double getOrderTotal() {
    return orderTotal;
  }
  public void setOrderTotal(Double orderTotal) {
    this.orderTotal = orderTotal;
  }
  public Double getOrderTotalNumber() {
    return orderTotalNumber;
  }
  public void setOrderTotalNumber(Double orderTotalNumber) {
    this.orderTotalNumber = orderTotalNumber;
  }
  public Double getOrderPayment() {
    return orderPayment;
  }
  public void setOrderPayment(Double orderPayment) {
    this.orderPayment = orderPayment;
  }
  public Double getOrderMargin() {
    return orderMargin;
  }
  public void setOrderMargin(Double orderMargin) {
    this.orderMargin = orderMargin;
  }
  public Double getOrderTotalPayment() {
    return orderTotalPayment;
  }
  public void setOrderTotalPayment(Double orderTotalPayment) {
    this.orderTotalPayment = orderTotalPayment;
  }
  public Double getOrderAvailableBalance() {
    return orderAvailableBalance;
  }
  public void setOrderAvailableBalance(Double orderAvailableBalance) {
    this.orderAvailableBalance = orderAvailableBalance;
  }
  public Double getOrderCredits() {
    return orderCredits;
  }
  public void setOrderCredits(Double orderCredits) {
    this.orderCredits = orderCredits;
  }
  public String getOrderTime() {
    return orderTime;
  }
  public void setOrderTime(String orderTime) {
    this.orderTime = orderTime;
  }
  public String getOrderDeliveryTime() {
    return orderDeliveryTime;
  }
  public void setOrderDeliveryTime(String orderDeliveryTime) {
    this.orderDeliveryTime = orderDeliveryTime;
  }
  public String getOrderStatus() {
    return orderStatus;
  }
  public void setOrderStatus(String orderStatus) {
    this.orderStatus = orderStatus;
  }
  public String getOrderReview() {
    return orderReview;
  }
  public void setOrderReview(String orderReview) {
    this.orderReview = orderReview;
  }
  public String getOrderReviewTime() {
    return orderReviewTime;
  }
  public void setOrderReviewTime(String orderReviewTime) {
    this.orderReviewTime = orderReviewTime;
  }
  public String getOrderFinancialAudit() {
    return orderFinancialAudit;
  }
  public void setOrderFinancialAudit(String orderFinancialAudit) {
    this.orderFinancialAudit = orderFinancialAudit;
  }
  public String getOrderFinancialAuditTime() {
    return orderFinancialAuditTime;
  }
  public void setOrderFinancialAuditTime(String orderFinancialAuditTime) {
    this.orderFinancialAuditTime = orderFinancialAuditTime;
  }
  public String getOrderSingle() {
    return orderSingle;
  }
  public void setOrderSingle(String orderSingle) {
    this.orderSingle = orderSingle;
  }
  public String getOrderSingleTime() {
    return orderSingleTime;
  }
  public void setOrderSingleTime(String orderSingleTime) {
    this.orderSingleTime = orderSingleTime;
  }
  public String getOrderDealer() {
    return orderDealer;
  }
  public void setOrderDealer(String orderDealer) {
    this.orderDealer = orderDealer;
  }
  public String getOrderDealerName() {
    return orderDealerName;
  }
  public void setOrderDealerName(String orderDealerName) {
    this.orderDealerName = orderDealerName;
  }
  public Integer getOrderType() {
    return orderType;
  }
  public void setOrderType(Integer orderType) {
    this.orderType = orderType;
  }
  public String getOrderCustomerType() {
    return orderCustomerType;
  }
  public void setOrderCustomerType(String orderCustomerType) {
    this.orderCustomerType = orderCustomerType;
  }
  public String getOrderCustomerAddress() {
    return orderCustomerAddress;
  }
  public void setOrderCustomerAddress(String orderCustomerAddress) {
    this.orderCustomerAddress = orderCustomerAddress;
  }
  public String getOrderContact() {
    return orderContact;
  }
  public void setOrderContact(String orderContact) {
    this.orderContact = orderContact;
  }
  public String getOrderContactPhone() {
    return orderContactPhone;
  }
  public void setOrderContactPhone(String orderContactPhone) {
    this.orderContactPhone = orderContactPhone;
  }
  public String getOrderContactFax() {
    return orderContactFax;
  }
  public void setOrderContactFax(String orderContactFax) {
    this.orderContactFax = orderContactFax;
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
  public String getOrderReviewName() {
    return orderReviewName;
  }
  public void setOrderReviewName(String orderReviewName) {
    this.orderReviewName = orderReviewName;
  }
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
  public Integer getDetailId() {
    return detailId;
  }
  public void setDetailId(Integer detailId) {
    this.detailId = detailId;
  }
  public String getDetailSeries() {
    return detailSeries;
  }
  public void setDetailSeries(String detailSeries) {
    this.detailSeries = detailSeries;
  }
  public String getDetailSeriesName() {
    return detailSeriesName;
  }
  public void setDetailSeriesName(String detailSeriesName) {
    this.detailSeriesName = detailSeriesName;
  }
  public String getDetailModel() {
    return detailModel;
  }
  public void setDetailModel(String detailModel) {
    this.detailModel = detailModel;
  }
  public String getDetailModelName() {
    return detailModelName;
  }
  public void setDetailModelName(String detailModelName) {
    this.detailModelName = detailModelName;
  }
  public Integer getDetailNumberGroup() {
    return detailNumberGroup;
  }
  public void setDetailNumberGroup(Integer detailNumberGroup) {
    this.detailNumberGroup = detailNumberGroup;
  }
  public Integer getDetailNumber() {
    return detailNumber;
  }
  public void setDetailNumber(Integer detailNumber) {
    this.detailNumber = detailNumber;
  }
  public Integer getDetailTotalNumber() {
    return detailTotalNumber;
  }
  public void setDetailTotalNumber(Integer detailTotalNumber) {
    this.detailTotalNumber = detailTotalNumber;
  }
  public String getDetailRoom() {
    return detailRoom;
  }
  public void setDetailRoom(String detailRoom) {
    this.detailRoom = detailRoom;
  }
  public Double getDetailHight() {
    return detailHight;
  }
  public void setDetailHight(Double detailHight) {
    this.detailHight = detailHight;
  }
  public Double getDetailWidth() {
    return detailWidth;
  }
  public void setDetailWidth(Double detailWidth) {
    this.detailWidth = detailWidth;
  }
  public String getDetailUnit() {
    return detailUnit;
  }
  public void setDetailUnit(String detailUnit) {
    this.detailUnit = detailUnit;
  }
  public String getDetailColor() {
    return detailColor;
  }
  public void setDetailColor(String detailColor) {
    this.detailColor = detailColor;
  }
  public String getDetailWaterType() {
    return detailWaterType;
  }
  public void setDetailWaterType(String detailWaterType) {
    this.detailWaterType = detailWaterType;
  }
  public String getDetailCenterDistance() {
    return detailCenterDistance;
  }
  public void setDetailCenterDistance(String detailCenterDistance) {
    this.detailCenterDistance = detailCenterDistance;
  }
  public String getDetailInterfaceCaliber() {
    return detailInterfaceCaliber;
  }
  public void setDetailInterfaceCaliber(String detailInterfaceCaliber) {
    this.detailInterfaceCaliber = detailInterfaceCaliber;
  }
  public Double getDetailMarketPrice() {
    return detailMarketPrice;
  }
  public void setDetailMarketPrice(Double detailMarketPrice) {
    this.detailMarketPrice = detailMarketPrice;
  }
  public Double getDetailMarketPriceAmount() {
    return detailMarketPriceAmount;
  }
  public void setDetailMarketPriceAmount(Double detailMarketPriceAmount) {
    this.detailMarketPriceAmount = detailMarketPriceAmount;
  }
  public Double getDetailMarketRetailPrice() {
    return detailMarketRetailPrice;
  }
  public void setDetailMarketRetailPrice(Double detailMarketRetailPrice) {
    this.detailMarketRetailPrice = detailMarketRetailPrice;
  }
  public Double getDetailMarketRetailPriceAmount() {
    return detailMarketRetailPriceAmount;
  }
  public void setDetailMarketRetailPriceAmount(
      Double detailMarketRetailPriceAmount) {
    this.detailMarketRetailPriceAmount = detailMarketRetailPriceAmount;
  }
  public String getDetailCustomFee() {
    return detailCustomFee;
  }
  public void setDetailCustomFee(String detailCustomFee) {
    this.detailCustomFee = detailCustomFee;
  }
  public Double getDetailTotalCustomFee() {
    return detailTotalCustomFee;
  }
  public void setDetailTotalCustomFee(Double detailTotalCustomFee) {
    this.detailTotalCustomFee = detailTotalCustomFee;
  }
  public Double getDetailShouldProduce() {
    return detailShouldProduce;
  }
  public void setDetailShouldProduce(Double detailShouldProduce) {
    this.detailShouldProduce = detailShouldProduce;
  }
  public String getDetailDeliveryTime() {
    return detailDeliveryTime;
  }
  public void setDetailDeliveryTime(String detailDeliveryTime) {
    this.detailDeliveryTime = detailDeliveryTime;
  }
  public String getDetailRemark() {
    return detailRemark;
  }
  public void setDetailRemark(String detailRemark) {
    this.detailRemark = detailRemark;
  }
  public String getDetailOrderStatus() {
    return detailOrderStatus;
  }
  public void setDetailOrderStatus(String detailOrderStatus) {
    this.detailOrderStatus = detailOrderStatus;
  }
  public String getDetailGeneratedStatus() {
    return detailGeneratedStatus;
  }
  public void setDetailGeneratedStatus(String detailGeneratedStatus) {
    this.detailGeneratedStatus = detailGeneratedStatus;
  }
  public Double getDetailPrice() {
    return detailPrice;
  }
  public void setDetailPrice(Double detailPrice) {
    this.detailPrice = detailPrice;
  }
  public Double getDetailMoney() {
    return detailMoney;
  }
  public void setDetailMoney(Double detailMoney) {
    this.detailMoney = detailMoney;
  }
  public String getDetailColorName() {
    return detailColorName;
  }
  public void setDetailColorName(String detailColorName) {
    this.detailColorName = detailColorName;
  }
  public String getDetailWaterTypeName() {
    return detailWaterTypeName;
  }
  public void setDetailWaterTypeName(String detailWaterTypeName) {
    this.detailWaterTypeName = detailWaterTypeName;
  }
  public String getDetailCenterDistanceName() {
    return detailCenterDistanceName;
  }
  public void setDetailCenterDistanceName(String detailCenterDistanceName) {
    this.detailCenterDistanceName = detailCenterDistanceName;
  }
  public String getDetailInterfaceCaliberName() {
    return detailInterfaceCaliberName;
  }
  public void setDetailInterfaceCaliberName(String detailInterfaceCaliberName) {
    this.detailInterfaceCaliberName = detailInterfaceCaliberName;
  }
  public String getDetailCustomFeeName() {
    return detailCustomFeeName;
  }
  public void setDetailCustomFeeName(String detailCustomFeeName) {
    this.detailCustomFeeName = detailCustomFeeName;
  }
  
  
  
}

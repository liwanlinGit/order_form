package com.study.model;

import javax.persistence.*;

@Table(name = "orders_detail")
public class OrderDetail {
    @Id
    @Column(name = "detail_id")
    private Integer detailId;

    /**
     * 系列
     */
    @Column(name = "detail_series")
    private String detailSeries;
    @Transient
    private String detailSeriesName;

    /**
     * 型号
     */
    @Column(name = "detail_model")
    private String detailModel;
    @Transient
    private String detailModelName;

    /**
     * 组数
     */
    @Column(name = "detail_number_group")
    private Integer detailNumberGroup;

    /**
     * 片数
     */
    @Column(name = "detail_number")
    private Integer detailNumber;

    /**
     * 片数小计
     */
    @Column(name = "detail_total_number")
    private Integer detailTotalNumber;

    /**
     * 房间
     */
    @Column(name = "detail_room")
    private String detailRoom;

    /**
     * 高
     */
    @Column(name = "detail_hight")
    private Double detailHight;

    /**
     * 宽
     */
    @Column(name = "detail_width")
    private Double detailWidth;

    /**
     * 单位
     */
    @Column(name = "detail_unit")
    private String detailUnit;

    /**
     * 颜色
     */
    @Column(name = "detail_color")
    private String detailColor;

    /**
     * 进水方式
     */
    @Column(name = "detail_water_type")
    private String detailWaterType;

    /**
     * 中心距
     */
    @Column(name = "detail_center_distance")
    private String detailCenterDistance;

    /**
     * 接口口径
     */
    @Column(name = "detail_interface_caliber")
    private String detailInterfaceCaliber;

    /**
     * 市场单价
     */
    @Column(name = "detail_market_price")
    private Double detailMarketPrice;

    /**
     * 市场价金额
     */
    @Column(name = "detail_market_price_amount")
    private Double detailMarketPriceAmount;

    /**
     * 市场零售价
     */
    @Column(name = "detail_market_retail_price")
    private Double detailMarketRetailPrice;

    /**
     * 市场零售金额
     */
    @Column(name = "detail_market_retail_price_amount")
    private Double detailMarketRetailPriceAmount;

    /**
     * 定制费单价
     */
    @Column(name = "detail_custom_fee")
    private String detailCustomFee;

    /**
     * 定制费小计
     */
    @Column(name = "detail_total_custom_fee")
    private Double detailTotalCustomFee;

    /**
     * 应生产量
     */
    @Column(name = "detail_should_produce")
    private Double detailShouldProduce;

    /**
     * 发货时间
     */
    @Column(name = "detail_delivery_time")
    private String detailDeliveryTime;

    /**
     * 备注
     */
    @Column(name = "detail_remark")
    private String detailRemark;

    /**
     * 订单状态
     */
    @Column(name = "detail_order_status")
    private String detailOrderStatus;

    /**
     * 生产状态
     */
    @Column(name = "detail_generated_status")
    private String detailGeneratedStatus;
    
    /**
     * 单价
     */
    @Column(name = "detail_price")
    private Double detailPrice;
    
    /**
     * 金额
     */
    @Column(name = "detail_money")
    private Double detailMoney;
    
    @Transient
    private String detailColorName;
    @Transient
    private String detailWaterTypeName;
    @Transient
    private String detailCenterDistanceName;
    @Transient
    private String detailInterfaceCaliberName;
    @Transient
    private String detailCustomFeeName;
    

    /**
     * 订单id
     */
    @Column(name = "order_id")
    private Integer orderId;

    /**
     * @return detail_id
     */
    public Integer getDetailId() {
        return detailId;
    }

    /**
     * @param detailId
     */
    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }

    /**
     * 获取系列
     *
     * @return detail_series - 系列
     */
    public String getDetailSeries() {
        return detailSeries;
    }

    /**
     * 设置系列
     *
     * @param detailSeries 系列
     */
    public void setDetailSeries(String detailSeries) {
        this.detailSeries = detailSeries;
    }

    /**
     * 获取型号
     *
     * @return detail_model - 型号
     */
    public String getDetailModel() {
        return detailModel;
    }

    /**
     * 设置型号
     *
     * @param detailModel 型号
     */
    public void setDetailModel(String detailModel) {
        this.detailModel = detailModel;
    }

    /**
     * 获取组数
     *
     * @return detail_number_group - 组数
     */
    public Integer getDetailNumberGroup() {
        return detailNumberGroup;
    }

    /**
     * 设置组数
     *
     * @param detailNumberGroup 组数
     */
    public void setDetailNumberGroup(Integer detailNumberGroup) {
        this.detailNumberGroup = detailNumberGroup;
    }

    /**
     * 获取片数
     *
     * @return detail_number - 片数
     */
    public Integer getDetailNumber() {
        return detailNumber;
    }

    /**
     * 设置片数
     *
     * @param detailNumber 片数
     */
    public void setDetailNumber(Integer detailNumber) {
        this.detailNumber = detailNumber;
    }

    /**
     * 获取片数小计
     *
     * @return detail_total_number - 片数小计
     */
    public Integer getDetailTotalNumber() {
        return detailTotalNumber;
    }

    /**
     * 设置片数小计
     *
     * @param detailTotalNumber 片数小计
     */
    public void setDetailTotalNumber(Integer detailTotalNumber) {
        this.detailTotalNumber = detailTotalNumber;
    }

    /**
     * 获取房间
     *
     * @return detail_room - 房间
     */
    public String getDetailRoom() {
        return detailRoom;
    }

    /**
     * 设置房间
     *
     * @param detailRoom 房间
     */
    public void setDetailRoom(String detailRoom) {
        this.detailRoom = detailRoom;
    }

    /**
     * 获取高
     *
     * @return detail_hight - 高
     */
    public Double getDetailHight() {
        return detailHight;
    }

    /**
     * 设置高
     *
     * @param detailHight 高
     */
    public void setDetailHight(Double detailHight) {
        this.detailHight = detailHight;
    }

    /**
     * 获取宽
     *
     * @return detail_width - 宽
     */
    public Double getDetailWidth() {
        return detailWidth;
    }

    /**
     * 设置宽
     *
     * @param detailWidth 宽
     */
    public void setDetailWidth(Double detailWidth) {
        this.detailWidth = detailWidth;
    }

    /**
     * 获取单位
     *
     * @return detail_unit - 单位
     */
    public String getDetailUnit() {
        return detailUnit;
    }

    /**
     * 设置单位
     *
     * @param detailUnit 单位
     */
    public void setDetailUnit(String detailUnit) {
        this.detailUnit = detailUnit;
    }

    /**
     * 获取颜色
     *
     * @return detail_color - 颜色
     */
    public String getDetailColor() {
        return detailColor;
    }

    /**
     * 设置颜色
     *
     * @param detailColor 颜色
     */
    public void setDetailColor(String detailColor) {
        this.detailColor = detailColor;
    }

    /**
     * 获取进水方式
     *
     * @return detail_water_type - 进水方式
     */
    public String getDetailWaterType() {
        return detailWaterType;
    }

    /**
     * 设置进水方式
     *
     * @param detailWaterType 进水方式
     */
    public void setDetailWaterType(String detailWaterType) {
        this.detailWaterType = detailWaterType;
    }

    /**
     * 获取中心距
     *
     * @return detail_center_distance - 中心距
     */
    public String getDetailCenterDistance() {
        return detailCenterDistance;
    }

    /**
     * 设置中心距
     *
     * @param detailCenterDistance 中心距
     */
    public void setDetailCenterDistance(String detailCenterDistance) {
        this.detailCenterDistance = detailCenterDistance;
    }

    /**
     * 获取接口口径
     *
     * @return detail_interface_caliber - 接口口径
     */
    public String getDetailInterfaceCaliber() {
        return detailInterfaceCaliber;
    }

    /**
     * 设置接口口径
     *
     * @param detailInterfaceCaliber 接口口径
     */
    public void setDetailInterfaceCaliber(String detailInterfaceCaliber) {
        this.detailInterfaceCaliber = detailInterfaceCaliber;
    }

    /**
     * 获取市场单价
     *
     * @return detail_market_price - 市场单价
     */
    public Double getDetailMarketPrice() {
        return detailMarketPrice;
    }

    /**
     * 设置市场单价
     *
     * @param detailMarketPrice 市场单价
     */
    public void setDetailMarketPrice(Double detailMarketPrice) {
        this.detailMarketPrice = detailMarketPrice;
    }

    /**
     * 获取市场价金额
     *
     * @return detail_market_price_amount - 市场价金额
     */
    public Double getDetailMarketPriceAmount() {
        return detailMarketPriceAmount;
    }

    /**
     * 设置市场价金额
     *
     * @param detailMarketPriceAmount 市场价金额
     */
    public void setDetailMarketPriceAmount(Double detailMarketPriceAmount) {
        this.detailMarketPriceAmount = detailMarketPriceAmount;
    }

    /**
     * 获取市场零售价
     *
     * @return detail_market_retail_price - 市场零售价
     */
    public Double getDetailMarketRetailPrice() {
        return detailMarketRetailPrice;
    }

    /**
     * 设置市场零售价
     *
     * @param detailMarketRetailPrice 市场零售价
     */
    public void setDetailMarketRetailPrice(Double detailMarketRetailPrice) {
        this.detailMarketRetailPrice = detailMarketRetailPrice;
    }

    /**
     * 获取市场零售金额
     *
     * @return detail_market_retail_price_amount - 市场零售金额
     */
    public Double getDetailMarketRetailPriceAmount() {
        return detailMarketRetailPriceAmount;
    }

    /**
     * 设置市场零售金额
     *
     * @param detailMarketRetailPriceAmount 市场零售金额
     */
    public void setDetailMarketRetailPriceAmount(Double detailMarketRetailPriceAmount) {
        this.detailMarketRetailPriceAmount = detailMarketRetailPriceAmount;
    }

    /**
     * 获取定制费单价
     *
     * @return detail_custom_fee - 定制费单价
     */
    public String getDetailCustomFee() {
        return detailCustomFee;
    }

    /**
     * 设置定制费单价
     *
     * @param detailCustomFee 定制费单价
     */
    public void setDetailCustomFee(String detailCustomFee) {
        this.detailCustomFee = detailCustomFee;
    }

    /**
     * 获取定制费小计
     *
     * @return detail_total_custom_fee - 定制费小计
     */
    public Double getDetailTotalCustomFee() {
        return detailTotalCustomFee;
    }

    /**
     * 设置定制费小计
     *
     * @param detailTotalCustomFee 定制费小计
     */
    public void setDetailTotalCustomFee(Double detailTotalCustomFee) {
        this.detailTotalCustomFee = detailTotalCustomFee;
    }

    /**
     * 获取应生产量
     *
     * @return detail_should_produce - 应生产量
     */
    public Double getDetailShouldProduce() {
        return detailShouldProduce;
    }

    /**
     * 设置应生产量
     *
     * @param detailShouldProduce 应生产量
     */
    public void setDetailShouldProduce(Double detailShouldProduce) {
        this.detailShouldProduce = detailShouldProduce;
    }

    /**
     * 获取发货时间
     *
     * @return detail_delivery_time - 发货时间
     */
    public String getDetailDeliveryTime() {
        return detailDeliveryTime;
    }

    /**
     * 设置发货时间
     *
     * @param detailDeliveryTime 发货时间
     */
    public void setDetailDeliveryTime(String detailDeliveryTime) {
        this.detailDeliveryTime = detailDeliveryTime;
    }

    /**
     * 获取备注
     *
     * @return detail_remark - 备注
     */
    public String getDetailRemark() {
        return detailRemark;
    }

    /**
     * 设置备注
     *
     * @param detailRemark 备注
     */
    public void setDetailRemark(String detailRemark) {
        this.detailRemark = detailRemark;
    }

    /**
     * 获取订单状态
     *
     * @return detail_order_status - 订单状态
     */
    public String getDetailOrderStatus() {
        return detailOrderStatus;
    }

    /**
     * 设置订单状态
     *
     * @param detailOrderStatus 订单状态
     */
    public void setDetailOrderStatus(String detailOrderStatus) {
        this.detailOrderStatus = detailOrderStatus;
    }

    /**
     * 获取生产状态
     *
     * @return detail_generated_status - 生产状态
     */
    public String getDetailGeneratedStatus() {
        return detailGeneratedStatus;
    }

    /**
     * 设置生产状态
     *
     * @param detailGeneratedStatus 生产状态
     */
    public void setDetailGeneratedStatus(String detailGeneratedStatus) {
        this.detailGeneratedStatus = detailGeneratedStatus;
    }

    /**
     * 获取订单id
     *
     * @return order_id - 订单id
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * 设置订单id
     *
     * @param orderId 订单id
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getDetailSeriesName() {
      return detailSeriesName;
    }

    public void setDetailSeriesName(String detailSeriesName) {
      this.detailSeriesName = detailSeriesName;
    }

    public String getDetailModelName() {
      return detailModelName;
    }

    public void setDetailModelName(String detailModelName) {
      this.detailModelName = detailModelName;
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
    
    
}
import ProfitServerRequest from "../server/request/product/sales/ProfitServerRequest.js";
import ProductServerRequest from "../server/request/product/ProductServerRequest.js";
import RevenueServerRequest from "../server/request/product/sales/RevenueServerRequest.js";
import SalesVolumeServerRequest from "../server/request/product/sales/SalesVolumeServerRequest.js";
import ServerErrorHandle from "../exception/ServerErrorHandle.js";

export default class HomeService {
    constructor() {
        this.productRequest = new ProductServerRequest();
        this.profitRequest = new ProfitServerRequest();
        this.revenueRequest = new RevenueServerRequest();
        this.salesVolumeRequest = new SalesVolumeServerRequest();
    }

    async getTodaySalesVolume() {
        const response = await this.salesVolumeRequest.getTodaySalesVolume();
        return ServerErrorHandle.checkResponseStatus(response);
    }

    async getTodayRevenue() {
        const response = await this.revenueRequest.getTodayRevenue();
        const data = ServerErrorHandle.checkResponseStatus(response);
        return this.#formatPrice(data);
    }

    async getTodayProfit() {
        const response = await this.profitRequest.getTodayProfit();
        const data = ServerErrorHandle.checkResponseStatus(response);
        return this.#formatPrice(data);
    }

    async getThisMonthSalesVolume() {
        const response = await this.salesVolumeRequest.getThisMonthSalesVolume();
        return ServerErrorHandle.checkResponseStatus(response);
    }

    async getThisMonthRevenue() {
        const response = await this.revenueRequest.getThisMonthRevenue();
        const data = ServerErrorHandle.checkResponseStatus(response);
        return this.#formatPrice(data);
    }

    async getThisMonthProfit() {
        const response = await this.profitRequest.getThisMonthProfit();
        const data = ServerErrorHandle.checkResponseStatus(response);
        return this.#formatPrice(data);
    }

    async getThisYearSalesVolume() {
        const response = await this.salesVolumeRequest.getThisYearSalesVolume();
        return ServerErrorHandle.checkResponseStatus(response);
    }

    async getThisYearRevenue() {
        const response = await this.revenueRequest.getThisYearRevenue();
        const data = ServerErrorHandle.checkResponseStatus(response);
        return this.#formatPrice(data);
    }

    async getThisYearProfit() {
        const response = await this.profitRequest.getThisYearProfit();
        const data = ServerErrorHandle.checkResponseStatus(response);
        return this.#formatPrice(data);
    }

    async getTodaySalesVolumeByHour() {
        const response = await this.salesVolumeRequest.getTodaySalesVolumeByHour();
        return ServerErrorHandle.checkResponseStatus(response);
    }

    async getThisMonthSalesVolumeByHour() {
        const response = await this.salesVolumeRequest.getThisMonthSalesVolumeByHour();
        return ServerErrorHandle.checkResponseStatus(response);
    }

    async getThisYearSalesByHour() {
        const response = await this.salesVolumeRequest.getThisYearSalesByHour();
        return ServerErrorHandle.checkResponseStatus(response);
    }

    async getTodayRevenueByHour() {
        const response = await this.revenueRequest.getTodayRevenueByHour();
        return ServerErrorHandle.checkResponseStatus(response);
    }

    async getThisMonthRevenueByHour() {
        const response = await this.revenueRequest.getThisMonthRevenueByHour();
        return ServerErrorHandle.checkResponseStatus(response);
    }

    async getThisYearRevenueByHour() {
        const response = await this.revenueRequest.getThisYearRevenueByHour();
        return ServerErrorHandle.checkResponseStatus(response);
    }

    async getTodayProfitByHour() {
        const response = await this.profitRequest.getTodayProfitByHour();
        return ServerErrorHandle.checkResponseStatus(response);
    }

    async getThisMonthProfitByHour() {
        const response = await this.profitRequest.getThisMonthProfitByHour();
        return ServerErrorHandle.checkResponseStatus(response);
    }

    async getThisYearProfitByHour() {
        const response = await this.profitRequest.getThisYearProfitByHour();
        return ServerErrorHandle.checkResponseStatus(response);
    }

    #formatPrice(price) {
        return new Intl.NumberFormat('ko-KR', { style: 'currency', currency: 'KRW' }).format(price);
    }

}
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

    #formatPrice(price) {
        return new Intl.NumberFormat('ko-KR', { style: 'currency', currency: 'KRW' }).format(price);
    }
}
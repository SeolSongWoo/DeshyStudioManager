import ProfitServerRequest from "../server/request/product/sales/ProfitServerRequest.js";
import ProductServerRequest from "../server/request/product/ProductServerRequest.js";
import RevenueServerRequest from "../server/request/product/sales/RevenueServerRequest.js";
import SalesVolumeServerRequest from "../server/request/product/sales/SalesVolumeServerRequest.js";
import ServerErrorHandle from "../exception/ServerErrorHandle.js";
import SaleServerRequest from "../server/request/product/sales/SaleServerRequest.js";

export default class HomeService {
    constructor() {
        this.productRequest = new ProductServerRequest();
        this.profitRequest = new ProfitServerRequest();
        this.revenueRequest = new RevenueServerRequest();
        this.salesVolumeRequest = new SalesVolumeServerRequest();
        this.saleServerRequest = new SaleServerRequest();
    }

    async getTodaySalesVolume() {
        const response = await this.salesVolumeRequest.getTodaySalesVolume();
        return ServerErrorHandle.checkResponseStatus(response);
    }

    async getTodayRevenue() {
        const response = await this.revenueRequest.getTodayRevenue();
        const data = ServerErrorHandle.checkResponseStatus(response);
        return this.formatPrice(data);
    }

    async getTodayProfit() {
        const response = await this.profitRequest.getTodayProfit();
        const data = ServerErrorHandle.checkResponseStatus(response);
        return this.formatPrice(data);
    }

    async getThisMonthSalesVolume() {
        const response = await this.salesVolumeRequest.getThisMonthSalesVolume();
        return ServerErrorHandle.checkResponseStatus(response);
    }

    async getThisMonthRevenue() {
        const response = await this.revenueRequest.getThisMonthRevenue();
        const data = ServerErrorHandle.checkResponseStatus(response);
        return this.formatPrice(data);
    }

    async getThisMonthProfit() {
        const response = await this.profitRequest.getThisMonthProfit();
        const data = ServerErrorHandle.checkResponseStatus(response);
        return this.formatPrice(data);
    }

    async getThisYearSalesVolume() {
        const response = await this.salesVolumeRequest.getThisYearSalesVolume();
        return ServerErrorHandle.checkResponseStatus(response);
    }

    async getThisYearRevenue() {
        const response = await this.revenueRequest.getThisYearRevenue();
        const data = ServerErrorHandle.checkResponseStatus(response);
        return this.formatPrice(data);
    }

    async getThisYearProfit() {
        const response = await this.profitRequest.getThisYearProfit();
        const data = ServerErrorHandle.checkResponseStatus(response);
        return this.formatPrice(data);
    }

    async getTodaySalesMetricsChartData() {
        return {
            profit: ServerErrorHandle.checkResponseStatus(await this.profitRequest.getTodayProfitByHour()),
            revenue: ServerErrorHandle.checkResponseStatus(await this.revenueRequest.getTodayRevenueByHour()),
            salesVolume: ServerErrorHandle.checkResponseStatus(await this.salesVolumeRequest.getTodaySalesVolumeByHour()),
            xaxis:this.getISOHoursArray(),
        }
    }

    async getThisMonthSalesMetricsChartData() {
        return {
            profit: ServerErrorHandle.checkResponseStatus(await this.profitRequest.getThisMonthProfitByHour()),
            revenue: ServerErrorHandle.checkResponseStatus(await this.revenueRequest.getThisMonthRevenueByHour()),
            salesVolume: ServerErrorHandle.checkResponseStatus(await this.salesVolumeRequest.getThisMonthSalesVolumeByHour()),
            xaxis:this.getISODaysArray(),
        }
    }

    async getThisYearSalesMetricsChartData() {
        return {
            profit: ServerErrorHandle.checkResponseStatus(await this.profitRequest.getThisYearProfitByHour()),
            revenue: ServerErrorHandle.checkResponseStatus(await this.revenueRequest.getThisYearRevenueByHour()),
            salesVolume: ServerErrorHandle.checkResponseStatus(await this.salesVolumeRequest.getThisYearSalesByHour()),
            xaxis:this.getISOMonthsArray(),
        }
    }

    async getRecentSalesByPaging(startPage,endPage) {
        const response = await this.saleServerRequest.getAllSaleByPaging(startPage,endPage);
        return ServerErrorHandle.checkResponseStatus(response);
    }

    getISOHoursArray() {
        let now = moment().startOf('hour');
        let startOfDay = moment().startOf('day');
        let times = [];

        for (let m = moment(startOfDay); m.isSameOrBefore(now); m.add(1, 'hours')) {
            times.push(m.local().format());
        }

        return times;
    }

    getISODaysArray() {
        let now = moment().startOf('day');
        let startOfDay = moment().startOf('month');
        let times = [];

        for (let m = moment(startOfDay); m.isSameOrBefore(now); m.add(1, 'days')) {
            times.push(m.local().format());
        }

        return times;
    }

    getISOMonthsArray() {
        let now = moment().startOf('month');
        let startOfDay = moment().startOf('year');
        let times = [];

        for (let m = moment(startOfDay); m.isSameOrBefore(now); m.add(1, 'months')) {
            times.push(m.local().format());
        }

        return times;
    }



    formatPrice(price) {
        return new Intl.NumberFormat('ko-KR', { style: 'currency', currency: 'KRW' }).format(price);
    }

}
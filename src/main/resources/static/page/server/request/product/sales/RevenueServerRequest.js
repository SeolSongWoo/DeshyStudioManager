import Fetch from "../../Fetch.js";

export default class RevenueServerRequest extends Fetch{

    constructor() {
        super('/api/products/metrics/revenue');
    }

    async getTotalRevenue() {
        return await this.fetch({
            httpMethod: 'GET',
        });
    }

    async getTodayRevenue() {
        return await this.fetch({
            url: '/today',
            httpMethod: 'GET',
        });
    }

    async getTodayRevenueByHour() {
        return await this.fetch({
            url: '/today/hour',
            httpMethod: 'GET',
        });
    }

    async getThisMonthRevenue() {
        return await this.fetch({
            url: '/month',
            httpMethod: 'GET',
        });
    }

    async getThisMonthRevenueByHour() {
        return await this.fetch({
            url: '/month/day',
            httpMethod: 'GET',
        });
    }

    async getThisYearRevenue() {
        return await this.fetch({
            url: '/year',
            httpMethod: 'GET',
        });
    }

    async getThisYearRevenueByHour() {
        return await this.fetch({
            url: '/year/month',
            httpMethod: 'GET',
        });
    }

}
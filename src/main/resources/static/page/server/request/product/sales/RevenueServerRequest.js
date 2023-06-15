import Fetch from "../../Fetch.js";

export default class RevenueServerRequest extends Fetch{

    constructor() {
        super('/api/products/sales/revenue');
    }

    async getTotalRevenue() {
        return await this.fetch({
            httpMethod: 'POST',
        });
    }

    async getTodayRevenue() {
        return await this.fetch({
            url: '/today',
            httpMethod: 'POST',
        });
    }

    async getThisMonthRevenue() {
        return await this.fetch({
            url: '/month',
            httpMethod: 'POST',
        });
    }

    async getThisYearRevenue() {
        return await this.fetch({
            url: '/year',
            httpMethod: 'POST',
        });
    }

}
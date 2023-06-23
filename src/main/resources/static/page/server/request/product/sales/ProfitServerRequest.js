import Fetch from "../../Fetch.js";

export default class ProfitServerRequest extends Fetch {
    constructor() {
        super('/api/products/metrics/profit');
    }

    async getTotalProfit() {
        return await this.fetch({
            httpMethod: 'GET',
        });
    }

    async getTodayProfit() {
        return await this.fetch({
            url: '/today',
            httpMethod: 'GET',
        });
    }

    async getTodayProfitByHour() {
        return await this.fetch({
            url: '/today/hour',
            httpMethod: 'GET',
        });
    }

    async getThisMonthProfit() {
        return await this.fetch({
            url: '/month',
            httpMethod: 'GET',
        });
    }

    async getThisMonthProfitByHour() {
        return await this.fetch({
            url: '/month/day',
            httpMethod: 'GET',
        });
    }

    async getThisYearProfit() {
        return await this.fetch({
            url: '/year',
            httpMethod: 'GET',
        });
    }

    async getThisYearProfitByHour() {
        return await this.fetch({
            url: '/year/month',
            httpMethod: 'GET',
        });
    }

}
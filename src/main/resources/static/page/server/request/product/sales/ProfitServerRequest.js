import Fetch from "../../Fetch.js";

export default class ProfitServerRequest extends Fetch {
    constructor() {
        super('/api/products/sales/profit');
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

    async getThisMonthProfit() {
        return await this.fetch({
            url: '/month',
            httpMethod: 'GET',
        });
    }

    async getThisYearProfit() {
        return await this.fetch({
            url: '/year',
            httpMethod: 'GET',
        });
    }

}
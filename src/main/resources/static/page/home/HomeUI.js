import HomeService from "./HomeService.js";

export default class HomeUI {
    #homeService;
    constructor() {
        this.#homeService = new HomeService();
    }

    async setElementTextContent(element,serviceMethod) {
        element.textContent = await this.#homeService[serviceMethod]();
    }

    addClickListenerToUpdateTextContent(listenerElement, textContentElement, serviceMethod) {
        listenerElement.addEventListener('click', async () => {
            textContentElement.textContent = await this.#homeService[serviceMethod]();
        });
    }

    setDefaultChartSettings({series, colors,xaxis,}) {
        series.forEach((object) => {
            
        });
    }

    get homeService() {
        return this.#homeService;
    }

}
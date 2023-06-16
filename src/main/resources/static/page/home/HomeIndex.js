import HomeUI from "./HomeUI.js";

const homeUI = new HomeUI();
const initTextContent = () => {
    const SalesPerformanceSetTextContents = () => {
        const profitTextElement = document.getElementById('profit');
        const revenueTextElement = document.getElementById('revenue');
        const salesVolumeTextElement = document.getElementById('salesVolume');
        return Promise.all([
            homeUI.setElementTextContent(profitTextElement, 'getTodayProfit'),
            homeUI.setElementTextContent(revenueTextElement, 'getTodayRevenue'),
            homeUI.setElementTextContent(salesVolumeTextElement, 'getTodaySalesVolume'),
        ]);
    }

    return Promise.all([
        SalesPerformanceSetTextContents(),
    ]);
}

const initChartSettings = () => {
    co
}

const initEventListeners = () => {
    const mainSalesInformationFilterAddEvents = () => {
        const mainSalesInformationFilterArray = [
            {
                className : '.volume-filter',
                textToElement : document.getElementById('salesVolume'),
                CardTitleTextToElement : document.getElementById('salesVolumeCardTitle'),
            },
            {
                className : '.revenue-filter',
                textToElement : document.getElementById('revenue'),
                CardTitleTextToElement : document.getElementById('revenueCardTitle'),
            },
            {
                className : '.profit-filter',
                textToElement : document.getElementById('profit'),
                CardTitleTextToElement : document.getElementById('profitCardTitle'),
            }
        ];
        mainSalesInformationFilterArray.forEach((object) => {
            document.querySelectorAll(object.className).forEach((element) => {
                const methodName = element.getAttribute('data-function');
                homeUI.addClickListenerToUpdateTextContent(element,object.textToElement,methodName);
                element.addEventListener('click', () => {
                    object.CardTitleTextToElement.textContent = `| ${element.textContent}`;
                });
            });
        });
    }

    mainSalesInformationFilterAddEvents();
}

const asyncProcess = async () => {
    await Promise.all([
        initTextContent(),
        ]
    );
}

const initializeHome = async () => {
    await asyncProcess();
    initEventListeners();
}

initializeHome();
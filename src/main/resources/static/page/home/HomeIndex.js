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

    const recentSalesSetTextContents = () => {
        const recentSalesTBodyElement = document.getElementById('recentSales');
        const tbody = recentSalesTBodyElement.getElementsByTagName('tbody')[0];
        return homeUI.setRecentSalesTBody(tbody);
    }

    return Promise.all([
        SalesPerformanceSetTextContents(),
        recentSalesSetTextContents(),
    ]);
}

const initChartSettings = () => {
    const salesChartInit = async () => {
        const salesChartElement = document.getElementById('reportsChart');
        await homeUI.setSalesChart(salesChartElement,'getTodaySalesMetricsChartData');
    }

    return Promise.all([
        salesChartInit(),
    ]);
}

const initEventListeners = () => {
    const mainSalesInformationFilterAddEvents = () => {
        const mainSalesInformationFilterArray = [
            {
                className : '.volume-filter',
                textToElement : document.getElementById('salesVolume'),
                CurrentDateTextToElement : document.getElementById('salesVolumeCardTitle'),
            },
            {
                className : '.revenue-filter',
                textToElement : document.getElementById('revenue'),
                CurrentDateTextToElement : document.getElementById('revenueCardTitle'),
            },
            {
                className : '.profit-filter',
                textToElement : document.getElementById('profit'),
                CurrentDateTextToElement : document.getElementById('profitCardTitle'),
            }
        ];
        mainSalesInformationFilterArray.forEach((object) => {
            document.querySelectorAll(object.className).forEach((element) => {
                const methodName = element.getAttribute('data-function');
                homeUI.addClickListenerToUpdateTextContent(element,object.textToElement,methodName);
                element.addEventListener('click', () => {
                    object.CurrentDateTextToElement.textContent = `| ${element.textContent}`;
                });
            });
        });
    }

    const chartSalesInformationFilterAddEvents = () => {
        const chartSalesInformationFilterObject =
            {
                className : '.chart-filter',
                chartElement : document.getElementById('reportsChart'),
                CurrentDateTextToElement : document.getElementById('chartCardTitle'),
            };
        document.querySelectorAll(chartSalesInformationFilterObject.className).forEach((element) => {
            const methodName = element.getAttribute('data-function');
            homeUI.addClickListenerToUpdateChart(element,chartSalesInformationFilterObject.chartElement,methodName);
            element.addEventListener('click', () => {
                chartSalesInformationFilterObject.CurrentDateTextToElement.textContent = `| ${element.textContent}`;
            });
        });
    }

    mainSalesInformationFilterAddEvents();
    chartSalesInformationFilterAddEvents();
}

const asyncProcess = async () => {
    await Promise.all([
        initTextContent(),
        initChartSettings(),
        ]
    );
}

const initializeHome = async () => {
    await asyncProcess();
    initEventListeners();
}

initializeHome();
import HomeUI from "./HomeUI.js";

const homeUI = new HomeUI();

function initPageTab() {
    document.querySelectorAll('.page-select').forEach(element => {
        homeUI.addPageTabClickEvent(element)
    })
}
function initTextContent() {
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
        const recentSalesTable = document.getElementById('recentSales');
        const tbody = recentSalesTable.getElementsByTagName('tbody')[0];
        return homeUI.setRecentSalesTBody(tbody);
    }

    const top3VendorSalesSetTextContents = () => {
        const vendorSalesTable = document.getElementById('vendorSales');
        const tbody = vendorSalesTable.getElementsByTagName('tbody')[0];
        return homeUI.setTop3VendorSalesTBody(tbody,'getTop3VolumeVendorsByLimits');
    }

    return Promise.all([
        SalesPerformanceSetTextContents(),
        recentSalesSetTextContents(),
        top3VendorSalesSetTextContents(),
    ]);
}

function initChartSettings() {
    const salesChartInit = async () => {
        const salesChartElement = document.getElementById('reportsChart');
        await homeUI.setSalesChart(salesChartElement,'getTodaySalesMetricsChartData');
    }

    return Promise.all([
        salesChartInit(),
    ]);
}

function initEventListeners() {
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

function asyncProcess() {
    return Promise.all([
        initTextContent(),
        initChartSettings(),
        ]
    );
}

async function initializeHome() {
    await asyncProcess();
    initEventListeners();
    initPageTab();
}

initializeHome();
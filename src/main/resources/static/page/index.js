import {initializeHome} from "./home/HomeIndex.js";
import {initializeProductRegPage} from "./product-reg/RegIndex.js";
import {mainTemplate} from "./template/main.js";
import {productRegTemplate} from "./template/productReg.js";


const router = () => {
    const app = document.getElementById('app');
    switch (window.location.pathname) {
        case '/v/home':
            app.innerHTML = mainTemplate;
            initializeHome();
            break;
        case '/v/products/create':
            app.innerHTML = productRegTemplate;
            initializeProductRegPage();
            break;
        default:
            app.innerHTML = mainTemplate;
    }
}

const navigate = (e) => {
    e.preventDefault();
    const path = e.currentTarget.href;
    window.history.pushState(null, '', path);
    router();
}

window.addEventListener('popstate', router);
document.addEventListener('DOMContentLoaded', router);
document.querySelectorAll('.page-select').forEach(page => {
    page.addEventListener('click',navigate);
})
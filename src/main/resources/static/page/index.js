import {initializeHome} from "./home/HomeIndex.js";
import {initializeProductRegPage} from "./product-reg/RegIndex.js";


const asyncInit = () => {
    return Promise.all([
        initializeHome(),
    ])
}
const syncInit = () => {
    initializeProductRegPage()
}



asyncInit();
syncInit();
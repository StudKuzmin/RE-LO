import * as manager from "./manager.js"

export const service = (function(){
    class Service {

        run(){
            manager.to_login_PAGE();
            manager.to_registration_PAGE();
            manager.do_search_products();
        }
    }


    return {
        start_site: function() { 
            new Service().run();
        }
    }
})();
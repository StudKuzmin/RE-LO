import * as manager from "./manager.js"

export const service = (function(){
    class Service {

        #to_login_PAGE(){
            manager.to_login_PAGE();
        }
        #to_registration_PAGE(){
            manager.to_registration_PAGE();
        }

        run(){
            this.#to_login_PAGE();
            this.#to_registration_PAGE();
        }
    }


    return {
        start_site: function() { 
            new Service().run();
        }
    }
})();
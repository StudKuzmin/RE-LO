export const token = (function(){
    const token = 0;
    return {
        setToken: function(token) { this.token = token; },
        getToken: function() { return this.token; }
    }
})()
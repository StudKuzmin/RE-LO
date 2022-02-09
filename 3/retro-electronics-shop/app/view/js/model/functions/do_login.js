import * as manager from "../../controller/manager.js"

export async function do_login(){
    document.getElementById("to_login").onclick = () => {
        let login = document.getElementById('log_data').value;
        let password = document.getElementById('pas_data').value;
        let logData = {
            login: login,
            password: password
        };

        fetch('/app/api/logData', {method: 'POST', headers: {'Content-Type': 'application/json;charset=utf-8', Authentication: manager.token.getToken()},body: JSON.stringify(logData)})
        .then(function(response) 
        {
            return response.text();
        })
        .then(function(data) 
        {
            manager.token.setToken(data);
            alert("SDFSDF" + manager.token.getToken());
        });

        
    }
}
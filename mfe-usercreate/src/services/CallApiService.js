import React from 'react';



const BASE_URL = 'http://localhost:8096';

    const delay = ms => new Promise(resolve => setTimeout(resolve, ms));
    const randomNumber = (min = 0, max = 1) =>
      Math.floor(Math.random() * (max - min + 1)) + min;
    const simulateNetworkLatency = (min = 30, max = 1500) =>
      delay(randomNumber(min, max));


   
    
    async function CallingGenericApi(endpoint, options = {}) {
        console.log("llega aqui para hacer el llamado exactamente");
      await simulateNetworkLatency();
    
      options.headers = {
        'Content-Type': 'application/json',
        Accept: 'application/json',
        origin: "localhost:3000"
  
      };
    
      const url = BASE_URL + endpoint;
console.log(`verifico la url ${url}` )

      const response = await fetch(url, options);
      const data = await response.json();
    
      return data;
    }
    
    const CallApiService = {
      service: {
        search() {
            console.log("llega al llamado por la api");
          return CallingGenericApi('/bff-soapservice/api/search?rut=1111-9');
        },
        create(badge) {
          return CallingGenericApi(`/badges`, {
            method: 'POST',
            body: JSON.stringify(badge),
          });
        },
        read(badgeId) {
          return CallingGenericApi(`/badges/${badgeId}`);
        },
        update(badgeId, updates) {
          return CallingGenericApi(`/badges/${badgeId}`, {
            method: 'PUT',
            body: JSON.stringify(updates),
          });
        },
        // Lo hubiera llamado `delete`, pero `delete` es un keyword en JavaScript asi que no es buena idea :P
        remove(badgeId) {
          return CallingGenericApi(`/badges/${badgeId}`, {
            method: 'DELETE',
          });
        },
      },
    };
    

export default CallApiService ;
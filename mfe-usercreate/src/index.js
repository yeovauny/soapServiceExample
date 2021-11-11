import React from 'react';
import ReactDOM from 'react-dom';
import MainPage from './components/MainPage'
import 'bootstrap/dist/css/bootstrap.css'

import App from '../src/components/App';
// this call the id on index.html
const container = document.getElementById('app');

ReactDOM.render( <MainPage/>, container);

 

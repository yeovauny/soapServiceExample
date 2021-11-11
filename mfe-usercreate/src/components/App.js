import React from 'react';
import {BrowserRouter, Switch, Route } from 'react-router-dom';
import Layout from './Layout';
import CreateUserForm from './CreateUserForm';
import SearchUserForm from './SearchUserForm';
import MenuBar from './MenuBar';
import Home from './Home';

function App(){

    
    return (
        <BrowserRouter>
            
                <Switch>
                    <Route exact path="/creacionusuarios" component={CreateUserForm}/>
                    <Route exact path="/buscarusuario" component={SearchUserForm}/>
                    <Route exact path="/modificarusuario" component={CreateUserForm}/>
                    <Route exact path="/eliminarusuario" component={CreateUserForm}/>
                    <Route exact path="/" component={Home}/>
                </Switch>
            
        </BrowserRouter>
    );

    
}

export default App;
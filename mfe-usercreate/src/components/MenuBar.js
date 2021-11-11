
import React from 'react';
import '../../src/global.css'
import './styles/MenuBar.css'
import { BrowserRouter, Link ,Router, Switch} from 'react-router-dom'
import 'bootstrap/dist/css/bootstrap.css'
class MenuBar extends React.Component{

    render(){
        
            return (
            
                <div className="MenuBar_Header">
                    <ul id="nav">
                    <li><a href="/">Home</a></li>
                    <li><a href="creacionusuarios">Crear Usuario</a></li>
                    <li><a href="buscarusuario">Buscar Usuario</a></li>
                    <li><a href="#">Contact</a></li>
                    </ul>
              </div>
                
            
                );
        
    }

}

export default MenuBar;

//https://stackoverflow.com/questions/50166035/how-to-implement-navbar-using-react
/**
 * 
 *  <div className="MenuBar_Info">
               
                <Switch>
                  <div className="MenuBar_Option">    
                  
                 
                    <Route path='/creacionusuarios' className="btn btn-primary">
                        <span>Crear usuario</span>    
                    </Route>
                  </div>
                    <div className="MenuBar_Option" >
                        <Route path='/eliminarusuario' className="btn btn-primary">
                            <span>Eliminar usuario</span>    
                        </Route>
                    </div>
                    <div className="MenuBar_Option">
                        <Route path='/modificarusuario' className="btn btn-primary">
                            <span>Modificar usuario</span>    
                        </Route>
                    </div>
                    <div className="MenuBar_Option">
                        <Route path='/buscarusuario' className="btn btn-primary">
                            <span>Buscar usuario</span>    
                        </Route>
                    </div>
                
                    </Switch>
                </div>
 * 
 * 
 * */ 
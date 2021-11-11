import React from 'react'

import MenuBar from './MenuBar'
import Footer from './Footer'
import App from './App'
import Layout from './Layout';
import CreateUserForm from './CreateUserForm'
import './styles/MainPage.css'
import './styles/Layout.css'

class MainPage extends React.Component{

    render(){

        return(
            <div>
                <div className="Layout_header">
                    <Layout/>
                </div>

                <div className="MainPage_Main">
                    <MenuBar/>
                </div>
                <div className="MainPage_Main">
                    <App/>
                </div>
              
                <div className="MainPage_Main">
                    <Footer/>
                </div>
            </div>
        );
    }


}

export default MainPage;
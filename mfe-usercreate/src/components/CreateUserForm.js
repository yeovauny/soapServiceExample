import React, { useState } from 'react';
import './styles/CreateUserForm.css'

import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import callApiService from '../services/CallApiService'
import api from '../services/CallApiService'

class CreateUserForm extends React.Component{

    state = {
        nombres:'',
        apellidos :'',
        rut:'',
        email:'',
        sexo:'',
        fechaNacimiento : new Date(),
      }

 

     constructor(props){
        super(props);
     }
   
    valueToState = (target) =>{
     
        this.setState ( ()=>{
           // let regex = new RegExp("[a-zA-Z]");
          //  if(target.name==="nombres" && regex.test(target.value)){
               console.log(target.name);
                return {[target.name]: target.value };
           // }
           // else 
            //   return { ...this.state} 
        });
    };
    
    dateValueToState =fechaNacimiento =>{
        this.setState({fechaNacimiento:fechaNacimiento});
    }

  
    handleSubmit(event) {
        console.log("llega a qui a llamar el metodo")
        alert('A name was submitted: ' + this.state.value);
        event.preventDefault();
      }


    sendInformation(){
        try{
            console.log("esta aqui y va empezar el proceso de llamados");
            const data= callApiService.service.search();
            
            console.log( "valor de respuesta "+ JSON.stringify(data));
        } catch(error){
            console.log("hay un error en el llamado");
            this.setState({loading: false , error: error});
        }
        console.log("llega a qui a llamar el metodo")
       // callApiService.getNewUserByRut();
    }


    // this method must be on component, and says what is the result on screen
    //<pre>{JSON.stringify(this.state, null ,2)}</pre>  add this line under title if you whant to know the values
    render(){
       

        return (<div className="CreateUserForm_Header">
            <div className="CreateUserForm_Table">
                <h5> Agregar Nuevo Usuario </h5> 
                  
                    <form  onSubmit={this.handleSubmit}>
                        <div className="form-group">
                            <label >Nombres</label>
                            <input className="form-control" type="text" name="nombres" onChange ={event => this.valueToState(event.target)} placeholder="Ingrese su nombre"/>
                        </div>
                        <div className="form-group">
                            <label >Apellidos</label>
                            <input className="form-control" type="text" name="apellidos" onChange ={event => this.valueToState(event.target)} placeholder="Ingrese sus apellidos"/>
                        </div>
                        
                        <div className="form-group">
                            <label >Rut</label>
                            <input className="form-control" onChange ={event => this.valueToState(event.target)} type="text"  name="rut" placeholder="Ingrese el Rut"/>
                        </div>
                        <div className="form-group">
                            <label >Email</label>
                            <input className="form-control" type="text" name="email" placeholder="ejemplo@gmail.com" onChange ={event => this.valueToState(event.target)}/>
                        </div>

                        <div>
                        <label >Fecha de Nacimiento</label>
                        <DatePicker selected={this.state.fechaNacimiento} name="fechaNacimiento" onChange={this.dateValueToState} minDate = {this.state.minDate} dateFormat="MM/dd/yyyy" />
                        </div>
      
                        <div className="form-group">
                            <label >Sexo</label>
                            <select  name ='sexo' class="form-control" onChange={event =>this.valueToState(event.target)}>
                                <option value={''}>Seleccionar</option>
                                <option value={'Hombre'}>Hombre</option>
                                <option value ={'Mujer'}>Mujer</option>
                            </select>

                        </div>
                        <button type="reset" className="CreateUserFrom_Buttom" class="btn btn-primary CreateUserFrom_Buttom">Resetear</button>
                        <button type="button" className="CreateUserFrom_Buttom"  class="btn btn-primary CreateUserFrom_Buttom" onClick={this.sendInformation}>Aceptar</button>                      
                    </form>
                </div>
       
             </div>);
    }
}
// this line is for export this compoment
export default CreateUserForm;
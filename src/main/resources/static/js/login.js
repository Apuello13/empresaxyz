/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$('#btn-e').on('click',function (){
    if (login.form.user.value==JsonData.username){  
        localStorage.setItem('session', JSON.stringify({id: 1, nombre: $('#user').val()}));
        window.location = '/dashboard'; 
    } 
    else{ 
         alert("Porfavor ingrese, nombre de usuario y contraseña correctos."); 
    } 

                      
});


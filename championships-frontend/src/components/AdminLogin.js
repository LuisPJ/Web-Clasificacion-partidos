import React, { useState } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import { useNavigate } from 'react-router-dom';

const AdminLogin = () => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const navigate=useNavigate();

    const handleLogin = async (e) => {
        e.preventDefault();

        try {
            const url = new URL('http://localhost:8080/api/v1/login');
            url.searchParams.append('email', email);
            url.searchParams.append('password', password);
      
            const response = await fetch(url, {
              method: 'GET',
              headers: {
                'Content-Type': 'application/json',
              },
            });

            //const responseData = await response.text();

            //window.alert(responseData);
      
            if (response.ok) {
              // Successful login, you can perform further actions here
              //console.log('Login successful');
              localStorage.setItem("isLoggedIn", "true");
              navigate("/RegisterGame", {replace: true});
            } else {
              // Handle error cases (401, 403, 404, etc.)
              window.alert("Incorrect user or password.");
              console.error('Login failed');
            }
          } catch (error) {
            console.error('Error during login:', error);
          }
    };

    const cardHeaderStyle = {
      fontWeight: 'bold'
    };

    return (
      <div className="container mt-5">
      <div className="row justify-content-center">
        <div className="col-md-6">
          <div className="card">
            <div style={cardHeaderStyle} className="card-header">ADMIN LOGIN</div>
            <div className="card-body">
              <form>
                <div className="mb-3">
                  <label htmlFor="inputEmail" className="form-label">
                    Email address
                  </label>
                  <input
                    type="email"
                    className="form-control"
                    id="inputEmail"
                    aria-describedby="emailHelp"
                    required
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                  />
                </div>
                <div className="mb-3">
                  <label htmlFor="inputPassword" className="form-label">
                    Password
                  </label>
                  <input
                    type="password"
                    className="form-control"
                    id="inputPassword"
                    required
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                  />
                </div>
                <button type="submit" className="btn btn-primary" onClick={handleLogin}>
                  Login
                </button>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
    );
};

export default AdminLogin;

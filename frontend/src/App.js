import logo from './logo.svg';
import './App.css';


import React, { useEffect, useState } from 'react';


function App() {

  const [users, setUsers] = useState([]);

    useEffect(() => {
      fetch('http://localhost:8080/api/users')
        .then((res) => res.json())
        .then((data) => setUsers(data));
    }, []);

    return (
      <div style={{ padding: '2rem' }}>
        <h1>사용자 목록</h1>
        <ul>
          {users.map((user) => (
            <li key={user.id}>
              이름: {user.name} / 나이: {user.age}
            </li>
          ))}
        </ul>
      </div>
    );


    //최초 생성시 있는 코드
  // return (
  //   <div className="App">
  //     <header className="App-header">
  //       <img src={logo} className="App-logo" alt="logo" />
  //       <p>
  //         Edit <code>src/App.js</code> and save to reload.
  //       </p>
  //       <a
  //         className="App-link"
  //         href="https://reactjs.org"
  //         target="_blank"
  //         rel="noopener noreferrer"
  //       >
  //         Learn React
  //       </a>
  //     </header>
  //   </div>
  // );
}

export default App;

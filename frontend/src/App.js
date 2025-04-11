import React from 'react';
import { UserProvider } from './userContext';
import UserForm from './UserForm';
import UserList from './UserList';

function App(){
  return (
    <UserProvider>
    <div style={{ padding: '2rem' }}>
      <h1>사용자 관리</h1>
      <UserForm />
      <UserList />
    </div>
  </UserProvider>
  );
}


//import React, { useEffect, useState } from 'react';
// function App() {
//   //[get, set] = 자료형 형태
//   const [users, setUsers] = useState([]);
//   const [name, setName] = useState('');
//   const [age, setAge] = useState('');


//     // 사용자 목록 가져오기
//     const fetchUsers = () => {
//       fetch('http://localhost:8080/api/users')
//         .then(res => res.json())
//         .then(data => setUsers(data));
//     };
  
//     useEffect(() => {
//       fetchUsers();
//     }, []);


//     // 사용자 추가 함수
//   const handleAddUser = (e) => {
//     e.preventDefault();

//     fetch('http://localhost:8080/api/users', {
//       method: 'POST',
//       headers: {
//         'Content-Type': 'application/json'
//       },
//       body: JSON.stringify({ name, age: parseInt(age) })
//     })
//       .then(res => {
//         if (res.ok) {
//           setName('');
//           setAge('');
//           fetchUsers(); // 목록 새로고침
//         } else {
//           alert('사용자 추가 실패');
//         }
//       });
//   };

//   return (
//     <div style={{ padding: '2rem' }}>
//       <h1>사용자 목록</h1>
//       <ul>
//         {users.map((user) => (
//           <li key={user.id}>
//             이름: {user.name}, 나이: {user.age}
//           </li>
//         ))}
//       </ul>

//       <h2>사용자 추가</h2>
//       <form onSubmit={handleAddUser}>
//         <input
//           type="text"
//           placeholder="이름"
//           value={name}
//           onChange={(e) => setName(e.target.value)}
//           required
//         />
//         <input
//           type="number"
//           placeholder="나이"
//           value={age}
//           onChange={(e) => setAge(e.target.value)}
//           required
//         />
//         <button type="submit">추가</button>
//       </form>
//     </div>
//   );

    // useEffect(() => {
    //   fetch('http://localhost:8080/api/users')
    //     .then((res) => res.json())
    //     .then((data) => setUsers(data));
    // }, []);

    // return (
    //   <div style={{ padding: '2rem' }}>
    //     <h1>사용자 목록</h1>
    //     <ul>
    //       {users.map((user) => (
    //         <li key={user.id}>
    //           이름: {user.name} / 나이: {user.age}
    //         </li>
    //       ))}
    //     </ul>
    //   </div>
    // );


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
//}

export default App;

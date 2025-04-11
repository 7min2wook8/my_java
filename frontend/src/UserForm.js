import React, { useState, useContext } from 'react';
import { UserContext } from './userContext';

function UserForm() {
  const [name, setName] = useState('');
  const [age, setAge] = useState('');
  const { dispatch } = useContext(UserContext);

  const handleSubmit = (e) => {
    e.preventDefault();
    const user = { name, age: parseInt(age) };

    fetch('http://localhost:8080/api/users', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(user),
    })
      .then((res) => res.json())
      .then((data) => {
        dispatch({ type: 'ADD_USER', payload: data });
        setName('');
        setAge('');
      });
  };

  return (
    <form onSubmit={handleSubmit}>
      <input value={name} onChange={(e) => setName(e.target.value)} placeholder="이름" required />
      <input value={age} onChange={(e) => setAge(e.target.value)} placeholder="나이" required type="number" />
      <button type="submit">추가</button>
    </form>
  );
}

export default UserForm;
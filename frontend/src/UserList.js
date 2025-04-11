import React, { useContext } from 'react';
import { UserContext } from './userContext';

function UserList() {
  const { state } = useContext(UserContext);

  return (
    <ul>
      {state.users.map((user) => (
        <li key={user.id}>
          이름: {user.name}, 나이: {user.age}
        </li>
      ))}
    </ul>
  );
}

export default UserList;
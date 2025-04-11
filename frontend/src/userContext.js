import React, { createContext, useReducer, useEffect } from 'react';

// 초기 상태
const initialState = {
  users: [],
};

// 리듀서
const reducer = (state, action) => {
  switch (action.type) {
    case 'SET_USERS':
      return { ...state, users: action.payload };
    case 'ADD_USER':
      return { ...state, users: [...state.users, action.payload] };
    default:
      return state;
  }
};

// Context 생성
export const UserContext = createContext();

// Provider 컴포넌트
export const UserProvider = ({ children }) => {
  const [state, dispatch] = useReducer(reducer, initialState);

  // 사용자 목록 fetch
  useEffect(() => {
    fetch('http://localhost:8080/api/users')
      .then((res) => res.json())
      .then((data) => dispatch({ type: 'SET_USERS', payload: data }));
  }, []);

  return (
    <UserContext.Provider value={{ state, dispatch }}>
      {children}
    </UserContext.Provider>
  );
};
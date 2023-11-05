export const setLocalStorage = (key: string, value: any) => {
    localStorage.setItem(key, JSON.stringify(value));
};

export const getLocalStorage = (key: string) => {
    let obj = localStorage.getItem(key);
    return JSON.parse(obj!);
};

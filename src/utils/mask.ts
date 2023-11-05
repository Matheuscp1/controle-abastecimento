export const maskNumber = (e: any) => {
  e.target.value = e.target.value.replace(/[^0-9]/g, '');
  return e;
};

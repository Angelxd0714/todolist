import { content as _content } from "flowbite-react/tailwind";
export const content = [
  './src/**/*.{js,jsx,ts,tsx}',
  'node_modules/flowbite-react/lib/esm/**/*.js',
  _content(),
];
export const theme = {
  extend: {},
};
export const plugins = [require('flowbite/plugin')];


[![Tests Passing](https://github.com/Behzadsharafi/PostcodeFrontend/actions/workflows/test.yml/badge.svg)](https://github.com/Behzadsharafi/PostcodeFrontend/actions/workflows/test.yml)
[![GitHub license](https://img.shields.io/badge/license-MIT-blue.svg)](https://github.com/Behzadsharafi/React-eShop/blob/main/LICENSE)

<div align='center'>

<h1> 📍 Postcode API 📬</h1>
<p>This is the backend of my <a href="https://github.com/Behzadsharafi/Postcodefrontend" target="_blank"> Postcode API </a>. An API that allows users to retrieve and add suburb and postcode combinations. I utilized Spring and MySQL for the backend of this project. The frontend is written in ReactJS and TypeScript . </p>

<h4> <a href="https://github.com/Behzadsharafi/Postcodeapi/issues"> Report a Bug </a> <span> · </span> <a href="https://github.com/Behzadsharafi/Postcodeapi/issues"> Request a Feature </a> </h4>

</div>

# :notebook_with_decorative_cover: Table of Contents

- [About the Project](#star2-about-the-project)
  - [Quick Demo](#camera-quick-demo)
  - [Features](#dart-features)
- [Getting Started](#toolbox-getting-started)
  - [Run Locally](#running-run-locally)
- [Contributing](#wave-contributing)
  - [Code of Conduct](#scroll-code-of-conduct)
  - [Built With](#computer-built-with)
- [License](#warning-license)
- [Contact](#handshake-contact)

## :star2: About the Project

### :camera: Quick Demo

<div align="center"> <a href="#"><img src="/src/main/images/demo.gif" alt='demo' width='800'/></a> </div>

### :dart: Features

- Finding a suburb using the postcode
- Finding a postcode using the suburb name
- Adding a suburb-postcode combination to the list

## :toolbox: Getting Started

### :running: Run Locally

- Create a MySQL database and call it "postcode_api"

- Clone the backend

```bash
  git clone git@github.com:Behzadsharafi/PostCodeAPI.git
```

- To run the backend open the project in a Java IDE like eclipse and run the APP.java

- Then clone the frontend

```bash
  git clone git@github.com:Behzadsharafi/PostcodeFrontend.git
```

- To run the front end go to the frontend directory

```bash
  cd EmployeeCreator/Employee-Creator-Frontend
```

- Install dependencies

```bash
  npm install
```

- Start the server

```bash
  npm run dev
```

- To seed the database you can open SuburbList.jsx and comment in the line below, and save the file.

```jsx
// dbSeeder.forEach((suburb) => createSuburb(suburb));
```

## :wave: Contributing

<a href="https://github.com/Behzadsharafi/PostcodeAPI/graphs/contributors"> <img src="https://contrib.rocks/image?repo=Louis3797/awesome-readme-template" /> </a>

Contributions are always welcome!

See [Contributing](https://github.com/Behzadsharafi/PostcodeAPI/blob/master/CONTRIBUTING.md) for ways to get started.

### :scroll: Code of Conduct

Please read the [Code of Conduct](https://github.com/Behzadsharafi/PostcodeAPI/blob/master/CODE_OF_CONDUCT.md).

## :computer: Built With

- [React](https://react.dev/): frontend
- [TypeScript](https://www.typescriptlang.org/): frontend
- [SASS](https://sass-lang.com/): styling
- [Vitest](https://vitest.dev/): frontend testing
- [MySQL](https://www.mysql.com/): database
- [Java](https://www.java.com/en/): backend
- [Spring](https://spring.io/): backend
- [JUnit5](https://junit.org/junit5/): backend testing

## :warning: License

Distributed under the MIT License. See [License](https://github.com/Behzadsharafi/PostcodeAPI/blob/master/LICENSE) for more information.

## :handshake: Contact

Email: behzadsharafi@gmail.com

Linkedin: [https://www.linkedin.com/in/zadsharafi/](https://www.linkedin.com/in/zadsharafi/)

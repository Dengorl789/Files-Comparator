[![hexlet-check](https://github.com/Dengorl789/java-project-71/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/Dengorl789/java-project-71/actions/workflows/hexlet-check.yml)
<a href="https://codeclimate.com/github/Dengorl789/java-project-71/maintainability"><img src="https://api.codeclimate.com/v1/badges/6e30e8a3d5691346d8ee/maintainability" /></a>
<a href="https://codeclimate.com/github/Dengorl789/java-project-71/test_coverage"><img src="https://api.codeclimate.com/v1/badges/6e30e8a3d5691346d8ee/test_coverage" /></a>

Help information

By cloning this repository, you get a file comparator of .json and .yml types of files.
Build project with Gradle by command "make build", then "make install" then use next command from app directory to compare two files:
./build/install/app/bin/app "filepath1" "filepath2"

Also you can choose format of a data been shown: plain, stylish of Json. 
Just add corresponding type after -f flag.
./build/install/app/bin/app -f *format* "filepath1" "filepath2"

Also you can use following console command for more help
./build/install/app/bin/app -h



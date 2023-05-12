job('MyJob') {
  description('This is my first Job DSL job')
  steps {
    shell('echo "Hello World"')
  }
}

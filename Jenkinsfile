// Added Shared Library
library identifier: 'cicdjenkins@master', retriever: modernSCM(
    [$class: 'GitSCMSource',
    remote: 'https://github.com/chetanpatel8476/jenkins-shared-library.git',
    //credentialsId: 'svc.devops-ut'
    ]
)

//buildStudentApp 'https://github.com/chetanpatel8476/Student-DynamoDB-Application.git', 'com.mydevopslab.studentapp'
buildStudentApp(
    ApplicationName : 'studentapp',
    GitRepoURL : 'https://github.com/chetanpatel8476/Student-DynamoDB-Application.git'
)
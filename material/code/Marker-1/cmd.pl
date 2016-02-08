#!/usr/bin/perl

# Script to compile the application in this directory
# Sergio Antoy, Thu Sep 30 15:16:17 PDT 1999

# Find on which host we are running

$hostname = `hostname`;
chomp($hostname);
print ("Compiling on host $hostname \n");

print ("Removing old class files \n");
system("rm -f *.class");

print ("Compiling all java files \n");
system("javac *.java");

print ("Running rmic to create Stub and Skel \n");
system("rmic Calculator");

print ("Make sure there is a route to remote host \n");
print ("   *** script does not check *** \n");
# system("/sbin/route");

print ("Running the registry \n");
system("rmiregistry &");

print ("Starting remote program \n");
system("java -Djava.security.policy=./java.policy Server &");

print ("Sleeping 10 secs. (you should see \"Server: Calculator bound\") \n");
system("sleep 10");

print ("Starting client \n");
system("java -Djava.security.policy=./java.policy Client" );

print ("Remember to kill remote program and registry \n");


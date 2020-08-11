#include<stdio.h>
int main() {
	char* data = "";
	char name[20];
	int age;
	int return_value = sscanf(data, "%s %i", name, &age);
	if(return_value == 1){
		printf("I'm %s.\n", name);
		printf("I'm %i years old.", age);
	}
}

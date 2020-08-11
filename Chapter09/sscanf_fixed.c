int main() {
	char* data = "John";
	char name[20];
	int age;
	int return_value = sscanf(data, "%s %i", name, &age);
	if(return_value == 2){
		printf("I'm %s.\n", name);
		printf("I'm %i years old.", age);
	}else if(return_value == -1){
		printf("ERROR: Unable to read the input data.\n");
	}else{
		printf("ERROR: 2 values expected, %d given.\n", return_value);
	}
}

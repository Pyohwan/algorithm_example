#include <stdio.h>
void my_test(char *val);

int main() {
	int num;
	char val[100];

	FILE *fp;
	fp = fopen("input.txt", "r");
	
	while(fscanf(fp, "%d %s", &num, val) != EOF) {
		my_test(val);
		printf("result %s\n", val);
		//val = {0,};
	}

	fclose(fp);
	//printf("hello world! %d, %s\n", num, val);



	return 0;
}

void my_test(char *val) {
	int idx1 = 0;
	int isEqual = 0;

	while (val[idx1] != '\0') {
		
		if (val[idx1] == val[idx1+1]) {
			int idx2 = idx1;
			while(val[idx2] = val[idx2+2]) {
				idx2++;
			}

		isEqual = 1;
		}

		//printf("%c", val[idx1]);
		idx1++;
	}

	if (isEqual == 1) {
		my_test(val);
	}
}

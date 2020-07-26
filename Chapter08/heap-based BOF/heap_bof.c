int main(int argc, char *argv[]) {
   char *buffer;
   buffer = malloc(10);
   strcpy(buffer, argv[1]);
   free(buffer);
   return 0;
}
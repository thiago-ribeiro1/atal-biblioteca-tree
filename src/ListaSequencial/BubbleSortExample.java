package ListaSequencial;

public class BubbleSortExample {



  public int[] bubbleSort(int[] arr){

      int tamanho = arr.length;
      boolean trocou;

      for (int i = 0; i < tamanho - 1; i++){
          trocou = false;

          for (int j = 0; j < tamanho - 1 - i; i++){
              if (arr[i] > arr[i + 1]) {
                  int temp = arr[j];
                  arr[j] = arr[j + 1];
                  arr[j + 1] = temp;
                  trocou = true;
              }
          }
          if (!trocou) break;
      }

      return arr;

  }




    public void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }

    }
}

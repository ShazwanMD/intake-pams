interface IUploadOptions {
  url: string;
  method: 'post' | 'put';
  file?: File;
  headers?: {[key: string]: string};
  formData?: FormData;
}
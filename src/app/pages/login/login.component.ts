import { Component} from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../../services/auth.service';
import { Subscription } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  constructor(
    private fb: FormBuilder,
    private service: AuthService,
    private router: Router
  ) {
    this.form = fb.group({
      userName: ['', [Validators.required]],
      password: ['', [Validators.required]],
    });
  }
  ngOnInit(): void {
    this.isSignin();
  }
  private subscription!: Subscription;
  title = 'front-end';
  error = ""
  form: FormGroup;
  
  public submit() {
      if (this.form.valid) {
        console.log(this.form.value)
        this.subscription  = this.service.login(this.form).subscribe({
          next: (value) => {
            this.service.setUser(value)
            this.router.navigateByUrl('/home')
            this.error = ""
          },
          error: (error) => {
            console.log('err', error)
            this.error = error.error.errors[0]
          }
        })
      }else{
        console.log('n')
      }
    }
    isSignin() {
      if (this.service.isSignin()) this.router.navigateByUrl('home');
    }
    ngOnDestroy() {
      // Realize o unsubscribe no ngOnDestroy para evitar memory leaks
      this.subscription?.unsubscribe();
    }
}

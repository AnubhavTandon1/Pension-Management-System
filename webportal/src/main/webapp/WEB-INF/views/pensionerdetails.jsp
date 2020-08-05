<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>Pension Form</title>
  </head>
  <body>
  <center>
    <h1>Pensioner's Details</h1>
</center>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  <div class="container">
  <form action="">
 
  <div class="form-group row">
    <label for="fullname" class="col-sm-2 col-form-label">Full name:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="fullname" placeholder="Enter Full Name"required>
    </div>
  </div>
  <div class="form-group row">
    <label for="birthday" class="col-sm-2 col-form-label">Birthday</label>
    <div class="col-sm-10">
      <input type="date" class="form-control"  id="birthday" placeholder="Birthday" required>
    </div>
  </div>
 
   <div class="form-group row">
    <label for="pan" class="col-sm-2 col-form-label">Pan</label>
    <div class="col-sm-10">
      <input type="text" class="form-control"  id="pan" placeholder="pan" pattern="^([a-zA-Z]){5}([0-9]){4}([a-zA-Z]){1}?$" required>
    </div>
  </div>
 
 
   <div class="form-group row">
    <label for="adhar" class="col-sm-2 col-form-label">Aadhar</label>
    <div class="col-sm-10">
      <input type="text" class="form-control"  id="adhar" placeholder="Aadhar"  maxlength="12" pattern="^[2-9]{1}[0-9]{3}[0-9]{4}[0-9]{4}$" required />
    </div>
  </div>
 
  <fieldset class="form-group">
    <div class="row">
      <legend class="col-form-label col-sm-2 pt-0">Type</legend>
      <div class="col-sm-10">
        <div class="form-check">
          <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios1" value="option1" checked>
          <label class="form-check-label" for="gridRadios1">
           Self
          </label>
        </div>
        <div class="form-check">
          <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios2" value="option2">
          <label class="form-check-label" for="gridRadios2">
           Family Pension
          </label>
        </div>
     
      </div>
    </div>
  </fieldset>
 
  <div class="form-group row">
    <div class="col-sm-10">
      <button type="submit" class="btn btn-primary">Submit</button>
    </div>
  </div>
</form>

  </div>
  </body>
</html>
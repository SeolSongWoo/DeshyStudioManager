export const productRegTemplate = `
<main id="main" class="main" data-page="product-reg-page">

    <div class="pagetitle">
        <h1>Form Elements</h1>
        <nav>
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="/home">Home</a></li>
                <li class="breadcrumb-item">상품관리</li>
                <li class="breadcrumb-item active">상품등록</li>
            </ol>
        </nav>
    </div><!-- End Page Title -->

    <section class="section">
        <div class="row">
            <div class="col-lg-6">

                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">상품등록</h5>

                        <!-- General Form Elements -->
                        <form class="needs-validation" id="productRegBtn" novalidate>
                            <div class="row mb-3">
                                <label for="name-product" class="col-sm-2 col-form-label">상품명</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="name" id="name-product"
                                           required>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <label for="vendor-product" class="col-sm-2 col-form-label">거래처</label>
                                <div class="col-sm-10">
                                    <div class="form-floating mb-3">
                                        <select class="form-select" name="vendor" id="vendor-product"
                                                aria-label="Floating label select example" required>
                                            <option selected disabled value="">거래처</option>
                                        </select>
                                        <label for="vendor-product">거래처</label>
                                    </div>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <label for="category-product" class="col-sm-2 col-form-label">카테고리</label>
                                <div class="col-sm-10">
                                    <div class="form-floating mb-3">
                                        <select class="form-select" name="category" id="category-product"
                                                aria-label="Floating label select example" required>
                                            <option selected disabled value="">카테고리</option>
                                        </select>
                                        <label for="category-product">카테고리</label>
                                    </div>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <label for="size-product" class="col-sm-2 col-form-label">사이즈</label>
                                <div class="col-sm-10">
                                    <div class="form-floating mb-3">
                                        <select class="form-select" name="size" id="size-product"
                                                aria-label="Floating label select example" required>
                                            <option selected disabled value="">사이즈</option>
                                        </select>
                                        <label for="size-product">사이즈</label>
                                    </div>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <label for="quantity-product" class="col-sm-2 col-form-label">수량</label>
                                <div class="col-sm-10">
                                    <input class="form-control" type="number" name="quantity"
                                           id="quantity-product" required>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <label for="originPrice-product" class="col-sm-2 col-form-label">가격</label>
                                <div class="col-sm-10">
                                    <input type="number" class="form-control" name="originPrice"
                                           id="originPrice-product" required>
                                </div>
                            </div>
                            <div class="col-12">
                                <button class="btn btn-primary float-end" type="submit"><font
                                        style="vertical-align: inherit;"><font
                                        style="vertical-align: inherit;">등록</font></font></button>
                            </div>
                        </form><!-- End General Form Elements -->

                    </div>
                </div>

            </div>
            <div class="col-lg-6">
                <div>

                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">카테고리 등록</h5>

                            <!-- Advanced Form Elements -->
                            <form class="needs-validation" id="categoryRegBtn" novalidate>
                                <div class="row mb-3">
                                    <label for="category-category" class="col-sm-3 col-form-label">카테고리 명</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" name="category" id="category-category"
                                               required>
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <label for="register-category" class="col-sm-3 col-form-label">등록된 카테고리</label>
                                    <div class="col-sm-9">
                                        <div class="form-control" id="register-category" style="min-height: 35px;">
                                            <div class="row" id="registered-category">
                                                <div class="form-control custom-pa-pm" style="min-height: 25px; width: auto">
                                                    <button type="button" name="CustomDeleteBtn" value="123" class="btn btn-danger btn-xs custom-btn-size"><span class="glyphicon glyphicon-remove">반팔티</span></button>
                                                </div>
                                                <div class="form-control custom-pa-pm" style="min-height: 25px; width: auto">
                                                    <button type="button" name="CustomDeleteBtn" value="123" class="btn btn-danger btn-xs custom-btn-size" style="--bs-btn-line-height: 1;"><span class="glyphicon glyphicon-remove">긴팔</span></button>
                                                </div>
                                                <div class="form-control custom-pa-pm" style="min-height: 25px; width: auto"></div>
                                                <div class="form-control custom-pa-pm" style="min-height: 25px; width: auto"></div>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                                <div class="col-12">
                                    <button class="btn btn-primary float-end" type="submit"><font
                                            style="vertical-align: inherit;"><font
                                            style="vertical-align: inherit;">등록</font></font></button>
                                </div>
                            </form><!-- End General Form Elements -->

                        </div>
                    </div>

                </div>
                <div>

                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">사이즈 등록</h5>

                            <!-- Advanced Form Elements -->
                            <form class="needs-validation" id="sizeRegBtn" novalidate>
                                <div class="row mb-3">
                                    <label for="category-size" class="col-sm-2 col-form-label">카테고리</label>
                                    <div class="col-sm-10">
                                        <div class="form-floating mb-3">
                                            <select class="form-select" name="category" id="category-size"
                                                    aria-label="Floating label select example" required>
                                                <option selected disabled value="">카테고리</option>
                                                <option value="반팔티">반팔티</option>
                                                <option value="2">M</option>
                                                <option value="3">S</option>
                                            </select>
                                            <label for="category-size">카테고리</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <label for="size-size" class="col-sm-2 col-form-label">사이즈 명</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="size" id="size-size"
                                               required>
                                    </div>
                                </div>
                                <div class="col-12">
                                    <button class="btn btn-primary float-end" type="submit"><font
                                            style="vertical-align: inherit;"><font
                                            style="vertical-align: inherit;">등록</font></font></button>
                                </div>
                            </form><!-- End General Form Elements -->
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </section>

</main><!-- End #main -->
`;
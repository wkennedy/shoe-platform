import React, {Component} from "react";
import PropTypes from "prop-types";
import {host} from "../config";
import fetch from 'isomorphic-unfetch'
import Grid from "@material-ui/core/Grid";
import FormGroup from "@material-ui/core/FormGroup";
import FormControl from "@material-ui/core/FormControl";
import InputLabel from "@material-ui/core/InputLabel";
import Select from "@material-ui/core/Select";
import MenuItem from "@material-ui/core/MenuItem";

class TrueToSize extends Component {

    constructor(props) {
        super(props);

        this.state = {
            brand: '',
            model: '',
            data: {}
        };

        this.handleInputChange = this.handleInputChange.bind(this);
        // this.handleSubmit = this.handleSubmit.bind(this);
    }

    renderBrandOptions() {
        return Object.keys(this.props.brandModels).map((brand, i) => {
            return (
                <MenuItem key={brand} value={brand}>{brand}</MenuItem>
            );
        });
    }

    handleInputChange(event) {
        const target = event.target;
        const value = target.type === 'checkbox' ? target.checked : target.value;
        const name = target.name;

        console.log("target: " + target + " value: " + value + " name: " + name);
        this.setState({
            [name]: value
        });
    }

    render() {
        // const {classes} = this.props;

        return (
            <div>
                {JSON.stringify(this.props.brandModels)}
                <Grid container spacing={8}>

                    <form>
                        <FormGroup row={true}>
                            <FormControl>
                                <InputLabel htmlFor="brandName-select">Brand</InputLabel>
                                <Select
                                    value={this.state.brand}
                                    onChange={this.handleInputChange}
                                    inputProps={{
                                        name: 'brandName',
                                        id: 'brandName-select',
                                    }}
                                >
                                    {this.renderBrandOptions()}
                                </Select>
                            </FormControl>
                        </FormGroup>
                    </form>
                </Grid>

            </div>
        )
    }

}

TrueToSize.getInitialProps = async function () {
    const brandModelsResponse = await fetch(host + '/shoes/brandModels');
    const brandModels = await brandModelsResponse.json();

    console.log("brandModels: " + JSON.stringify(brandModels));
    //
    // const placeholdersResponse = await fetch(host + '/cloud/placeholders');
    // const placeholders = await placeholdersResponse.json();
    //
    return {
        brandModels
    }
};

// TrueToSize.propTypes = {
//     classes: PropTypes.object.isRequired,
// };

export default TrueToSize